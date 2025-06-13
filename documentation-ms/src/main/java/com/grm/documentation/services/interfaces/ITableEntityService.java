package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.TableBasicDTO;
import com.grm.documentation.models.entities.TableEntity;
import java.util.List;

public interface ITableEntityService {

    List<TableEntity> getAll();
    TableEntity findById(Long id);
    TableEntity create(TableEntity tableEntity);
    void deleteBuId(Long id);

    TableBasicDTO getTableBasicDtoById(Long id);
}
