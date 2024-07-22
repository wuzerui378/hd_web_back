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



    public AreaList getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<AreaList> getByRegionClusterSubmitId(int regionClusterSubmitId) {
        return repository.findByRegionClusterId(regionClusterSubmitId);
    }

    public void saveAll(List<AreaList> areaLists) {
        repository.saveAll(areaLists);
    }

    public void updateAll(int id, List<AreaList> areaLists) {
        for (AreaList areaList : areaLists) {
            areaList.setRegionClusterId(id); // 假设有这个字段
            repository.save(areaList);
        }
    }

    public void deleteByRegionClusterSubmitId(int regionClusterSubmitId) {
        repository.deleteByRegionClusterSubmitId(regionClusterSubmitId);
    }

}
