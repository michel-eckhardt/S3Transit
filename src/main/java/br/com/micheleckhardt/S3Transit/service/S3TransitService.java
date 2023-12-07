package br.com.micheleckhardt.S3Transit.service;

import br.com.micheleckhardt.S3Transit.configs.AwsProperties;
import br.com.micheleckhardt.S3Transit.exceptions.FileAlreadyExistsException;
import br.com.micheleckhardt.S3Transit.util.FilesManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class S3TransitService {

    private final AwsProperties awsProperties;
    private final S3Client s3Client;

    @Autowired
    public S3TransitService(AwsProperties awsProperties) {
        this.awsProperties = awsProperties;

        this.s3Client = S3Client.builder()
                .region(Region.of(awsProperties.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
                        awsProperties.getAccessKeyId(), awsProperties.getSecretKey())))
                .build();
    }

    public void uploadFile(MultipartFile multipartFile, String name) {

        try {
            String fileExtension = FilesManagerUtil.getFileExtension(multipartFile.getOriginalFilename());
            String fileName = name+fileExtension;
            String key = fileName;

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(multipartFile.getBytes());

            isFileExists(key,s3Client);

            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(awsProperties.getBucketName())
                    .key(key)
                    .build(), RequestBody.fromBytes(byteArrayOutputStream.toByteArray()));

            byteArrayOutputStream.close();
        }catch (FileAlreadyExistsException e){
            throw e;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void isFileExists(String key, S3Client s3Client){
        try {
            // Criar uma solicitação para verificar se o objeto existe
            HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                    .bucket(awsProperties.getBucketName())
                    .key(key)
                    .build();

            // Executar a solicitação para obter os metadados do objeto
            HeadObjectResponse headObjectResponse = s3Client.headObject(headObjectRequest);
            throw new FileAlreadyExistsException();

        } catch (S3Exception e) {}

    }

    public void deleteFile(String bucketName, String key) {
        try {
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(awsProperties.getBucketName())
                    .key(bucketName+key)
                    .build();

            s3Client.deleteObject(deleteObjectRequest);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<S3Object> listFiles(String bucketName){

        try {
            ListObjectsRequest listObjectsRequest = ListObjectsRequest.builder()
                    .bucket(bucketName)
                    .build();

            ListObjectsResponse listObjectsResponse = s3Client.listObjects(listObjectsRequest);
            return listObjectsResponse.contents();

        }catch (Exception ex){
            throw new RuntimeException(ex);
        }


    }

}