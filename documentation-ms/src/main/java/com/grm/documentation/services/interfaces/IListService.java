package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.ListBasicDTO;

import java.util.List;

public interface IListService {

    List<com.grm.documentation.models.entities.List> findAll();
    com.grm.documentation.models.entities.List findById(Long id);
    com.grm.documentation.models.entities.List save(com.grm.documentation.models.entities.List list);
    void deleteById(Long id);

    ListBasicDTO getListBasicDtoById(Long id);
}
