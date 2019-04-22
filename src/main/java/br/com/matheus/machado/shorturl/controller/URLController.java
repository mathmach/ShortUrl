package br.com.matheus.machado.shorturl.controller;

import br.com.matheus.machado.shorturl.dto.ResponseDTO;
import br.com.matheus.machado.shorturl.dto.UrlDTO;
import br.com.matheus.machado.shorturl.dto.converter.UrlDTOConverter;
import br.com.matheus.machado.shorturl.entity.Url;
import br.com.matheus.machado.shorturl.service.UrlService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

    private static final Logger LOGGER = LoggerFactory.getLogger(URLController.class);

    @Autowired
    UrlService service;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @GetMapping(value = "/r/{alias}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<UrlDTO>> findByAlias(@PathVariable final String alias) {
        LOGGER.info("Find short url by alias: " + alias);
        final ResponseDTO<UrlDTO> res = new ResponseDTO<>(new ArrayList<>());
        try {
            service.findByAlias(alias).ifPresentOrElse((Url url) -> {
                res.setStatus(HttpStatus.OK.value());
                res.setData(UrlDTOConverter.convertToDTO(url));
                try {
                    response.sendRedirect(url.getUrl());
                } catch (IOException e) {
                    LOGGER.error(e.getLocalizedMessage(), e);
                    res.setStatus(HttpStatus.BAD_REQUEST.value());
                    res.setError("Bad Request");
                    res.getErrors().add(e.getLocalizedMessage());
                }
            }, () -> {
                res.setStatus(HttpStatus.NO_CONTENT.value());
                res.setError("No Content");
                res.getErrors().add("Alias " + alias + " not found!");
            });
        } catch (Exception e) {
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            res.setError("Bad Request");
            res.getErrors().add(e.getLocalizedMessage());
        }
        res.setTimestamp(new Date());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping(value = "/api/v2/shortener", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<String>> shortenUrl(@RequestBody @Valid final UrlDTO dto) {
        LOGGER.info("Generating short url of: " + dto.getUrl());
        final ResponseDTO<String> res = new ResponseDTO<>(new ArrayList<>());
        try {
            service.findByAlias(dto.getAlias()).ifPresentOrElse((Url url) -> {
                res.setStatus(HttpStatus.BAD_REQUEST.value());
                res.setError("Bad Request");
                res.getErrors().add("Alias " + url.getAlias() + " already exists!");
            }, () -> {
                Url url = service.save(UrlDTOConverter.convertToEntity(dto));
                res.setStatus(HttpStatus.OK.value());
                res.setData(request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()) + "/r/" + url.getAlias());
            });
        } catch (Exception e) {
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            res.setError("Bad Request");
            res.getErrors().add(e.getLocalizedMessage());
        }
        res.setTimestamp(new Date());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
