package br.com.micheleckhardt.S3Transit.controller;

import br.com.micheleckhardt.S3Transit.service.S3TransitService;
import br.com.micheleckhardt.S3Transit.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1")
public class S3TransitController {

    private final S3TransitService s3TransitService;

    @Autowired
    public S3TransitController(S3TransitService s3TransitService) {
        this.s3TransitService = s3TransitService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam String name) {
        s3TransitService.uploadFile(multipartFile, name);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpStatus.CREATED.value(), "Upload bem-sucedido"));
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<?> deleteFile(@PathVariable String fileName) {
        String bucketFolder = "multprocessos/arquivos-anexos/";
        s3TransitService.deleteFile(bucketFolder, fileName);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpStatus.CREATED.value(), "Arquivo deletado com sucesso"));
    }

    @GetMapping("/objects/{bucketname}")
    public ResponseEntity<?> getFiles(@PathVariable String bucketname){
        return ResponseEntity.status(HttpStatus.OK).body(s3TransitService.listFiles(bucketname));
    }

}