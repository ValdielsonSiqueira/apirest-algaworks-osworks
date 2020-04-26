package com.algaworks.osworks.api.exceptionhandler;

import com.algaworks.osworks.domain.exception.NegocioException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
    public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    private ResponseEntity<Object> handleNagocio(NegocioException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatus(status.value());
        exceptionMessage.setTitulo(ex.getMessage());
        exceptionMessage.setDataHora(LocalDateTime.now());

        return handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

            var campos = new ArrayList<ExceptionMessage.Campo>();

            for (ObjectError error : ex.getBindingResult().getAllErrors()){
                String nome = ((FieldError) error).getField();
                String mensagem = error.getDefaultMessage();

                campos.add(new ExceptionMessage.Campo(nome, mensagem));
            }

            var exceptionmessage = new ExceptionMessage();

            exceptionmessage.setStatus(status.value());
            exceptionmessage.setTitulo("Um ou mais campos estão inválidos. " +
                    "Faça o preenchimento correto dos campos e tente novamente");
            exceptionmessage.setDataHora(LocalDateTime.now());
            exceptionmessage.setCampos(campos);

            return super.handleExceptionInternal(ex, exceptionmessage, headers, status, request);
    }
}
