package br.com.micheleckhardt.S3Transit.util;

public class FilesManagerUtil {

    /**
     * Retorna a extenção do arquivo. EXP: .xml .png
     *
     * @param fileName Nome completo do arquivo. exemplo.xml
     * @return retorna somente a extenção .xml
     */
    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
}
