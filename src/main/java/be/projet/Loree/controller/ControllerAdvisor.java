package be.projet.Loree.controller;

import be.projet.Loree.exceptions.ResourceNotFoundException;
import be.projet.Loree.models.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

//@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest req){

        ErrorDTO errorDTO = ErrorDTO.builder()
                .status( HttpStatus.NOT_FOUND )
                .message( ex.getMessage() )
                .requestMadeAt( LocalDateTime.now() )
                .URI( req.getRequestURI() )
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );

//        return new ResponseEntity<>(errorDTO, headers, HttpStatus.NOT_FOUND);
        return ResponseEntity.status( HttpStatus.NOT_FOUND )
                .headers( headers )
                .body( errorDTO );

    }

}
