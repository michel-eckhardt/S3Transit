package br.com.micheleckhardt.S3Transit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FileAlreadyExistsException extends RuntimeException {

    public FileAlreadyExistsException() {
        super("Arquivo ja existe");
    }
    public FileAlreadyExistsException(String message) {
        super(message);
    }
}