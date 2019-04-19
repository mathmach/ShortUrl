package br.com.matheus.machado.shorturl.dto.converter;

import br.com.matheus.machado.shorturl.dto.UrlDTO;
import br.com.matheus.machado.shorturl.entity.Url;

public class UrlDTOConverter {

    public static UrlDTO convertToDTO(Url url) {
        UrlDTO dto = new UrlDTO();

        dto.setId(url.getId());
        dto.setAlias(url.getAlias());
        dto.setUrl(url.getUrl());

        return dto;
    }

    public static Url convertToEntity(UrlDTO dto) {
        Url url = new Url();

        url.setId(dto.getId());
        url.setAlias(dto.getAlias());
        url.setUrl(dto.getUrl());

        return url;
    }

}
