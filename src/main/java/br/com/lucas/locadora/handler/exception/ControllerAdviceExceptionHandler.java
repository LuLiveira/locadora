package br.com.lucas.locadora.handler.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lucas.locadora.handler.exception.util.Erro;
import feign.FeignException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Erro> handlePedidoNaoEncontradoException(final HttpServletRequest request, final FeignException e){
		return ResponseEntity.status(NOT_FOUND).body(new Erro(e.getMessage(), request.getServletPath()));
	}
}
