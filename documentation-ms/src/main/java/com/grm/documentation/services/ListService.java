package com.grm.documentation.services;

import com.grm.documentation.models.dto.ListBasicDTO;
import com.grm.documentation.models.entities.List;
import com.grm.documentation.repositories.ListRepository;
import com.grm.documentation.services.interfaces.IListService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListService implements IListService {

    private final ListRepository listRepository;

    @Autowired
    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public java.util.List<List> findAll() {
        return listRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List findById(Long id) {
        return listRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    @Override
    @Transactional
    public List save(List list) {
        return listRepository.save(list);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        listRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ListBasicDTO getListBasicDtoById(Long id) {
        List item = listRepository.findById(id).orElseThrow(() -> new RuntimeException("List not found with id: " + id));
        return ListBasicDTO.fromEntity(item);
    }
}
