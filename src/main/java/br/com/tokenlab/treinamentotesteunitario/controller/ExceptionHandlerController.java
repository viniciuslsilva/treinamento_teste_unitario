package br.com.tokenlab.treinamentotesteunitario.controller;

import br.com.tokenlab.treinamentotesteunitario.dto.ErrorDTO;
import br.com.tokenlab.treinamentotesteunitario.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> handleBadRequestError(BadRequestException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleError(Exception e) {
        log.error(e.getMessage());

        return new ResponseEntity<>(new ErrorDTO("Erro interno de servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}