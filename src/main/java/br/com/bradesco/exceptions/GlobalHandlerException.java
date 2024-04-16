package br.com.bradesco.exceptions;

import br.com.bradesco.domain.payload.dto.MessageExceptionHandlerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalHandlerException {

    public static final String USUARIO_NAO_ENCONTRADO = "usuario não encontrado";
    public static final String TELEFONE_NAO_ENCONTRADO = "Telefone nao encontrado";
    public static final String ENDERECO_NAO_ENCONTRADO = "Endereco nao encontrado";

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<MessageExceptionHandlerDTO> handleUsuarioNotFoundException(UsuarioNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return buildMessageExceptionHandlerDTO(
                USUARIO_NAO_ENCONTRADO,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TelefoneNotFoundException.class)
    public ResponseEntity<MessageExceptionHandlerDTO> handleUsuarioNotFoundException(TelefoneNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return buildMessageExceptionHandlerDTO(
                TELEFONE_NAO_ENCONTRADO,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<MessageExceptionHandlerDTO> handleUsuarioNotFoundException(EnderecoNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return buildMessageExceptionHandlerDTO(
                ENDERECO_NAO_ENCONTRADO,
                HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<MessageExceptionHandlerDTO> buildMessageExceptionHandlerDTO(String message, HttpStatus status) {
        return ResponseEntity.status(status)
                .body(MessageExceptionHandlerDTO.builder()
                        .message(message)
                        .build());
    }

}
