package br.com.micheleckhardt.S3Transit.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseMessage {
	
	private int statusCode;
	private String message;
		
}