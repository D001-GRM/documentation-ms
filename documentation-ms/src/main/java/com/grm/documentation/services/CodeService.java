package com.grm.documentation.services;

import com.grm.documentation.models.entities.Code;
import com.grm.documentation.repositories.CodeRepository;
import com.grm.documentation.services.interfaces.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodeService implements ICodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Code> findAll() {
        return codeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Code findById(Long id) {
        return codeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Code not found with id: " + id));
    }

    @Override
    @Transactional
    public Code save(Code code) {
        return codeRepository.save(code);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        codeRepository.deleteById(id);
    }
}
