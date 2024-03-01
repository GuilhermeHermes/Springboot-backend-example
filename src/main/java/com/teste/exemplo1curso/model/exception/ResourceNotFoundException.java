package com.teste.exemplo1curso.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);
   public ResourceNotFoundException(String mensagem){
       super(mensagem);
       logger.info("ENTROU AQUI");
   }
}
