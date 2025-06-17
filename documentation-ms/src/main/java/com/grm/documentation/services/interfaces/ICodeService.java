package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.entities.Code;

import java.util.List;

public interface ICodeService {

    List<Code> findAll();
    Code findById(Long id);
    Code save(Code code);
    void deleteById(Long id);

}
