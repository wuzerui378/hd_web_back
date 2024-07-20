package org.area.service;

import org.area.dao.AreaListRepository;
import org.area.model.AreaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaListService {
    @Autowired
    private AreaListRepository repository;

    public List<AreaList> getAllAreaLists() {
        return repository.findAll();
    }

    public List<AreaList> getAll() {
        return repository.findAll();
    }

    public AreaList getById(int id) {
        return repository.findById(id).orElse(null);
    }

    // 修改方法名以匹配仓库中的方法
    public List<AreaList> getByRegionClusterSubmitId(int regionClusterSubmitId) {
        return repository.findByRegionClusterSubmit_Id(regionClusterSubmitId);
    }

    public AreaList save(AreaList areaList) {
        return repository.save(areaList);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
