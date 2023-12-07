package br.com.micheleckhardt.S3Transit.controller;

import br.com.micheleckhardt.S3Transit.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class Health {

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(HttpStatus.OK.value(), "Online"));
    }
}
