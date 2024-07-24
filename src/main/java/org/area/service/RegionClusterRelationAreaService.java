package org.area.service;

import jakarta.transaction.Transactional;
import org.area.dao.AreaListRepository;
import org.area.model.AreaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RegionClusterRelationAreaService {
    @Autowired
    private AreaListRepository repository;

    public List<AreaList> getAllAreaLists() {
        return repository.findAll();
    }

    public AreaList getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public AreaList save(AreaList areaList) {
        return repository.save(areaList);
    }

    public void update(int id, AreaList areaList) {
        areaList.setId(id);
        repository.save(areaList);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
