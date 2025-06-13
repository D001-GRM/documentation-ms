package com.grm.documentation.services;

import com.grm.documentation.models.dto.TableBasicDTO;
import com.grm.documentation.models.entities.TableEntity;
import com.grm.documentation.repositories.TableEntityRepository;
import com.grm.documentation.services.interfaces.ITableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TableEntityService implements ITableEntityService {

    private final TableEntityRepository tableEntityRepository;

    @Autowired
    public TableEntityService(TableEntityRepository tableEntityRepository) {
        this.tableEntityRepository = tableEntityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TableEntity> getAll() {
        return tableEntityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TableEntity findById(Long id) {
        return tableEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TableEntity not found with id: " + id));
    }

    @Override
    @Transactional
    public TableEntity create(TableEntity tableEntity) {
        return tableEntityRepository.save(tableEntity);
    }

    @Override
    @Transactional
    public void deleteBuId(Long id) {
        tableEntityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TableBasicDTO getTableBasicDtoById(Long id) {
        TableEntity item = tableEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TableEntity not found with id: " + id));
        return TableBasicDTO.fromEntity(item);
    }

}
