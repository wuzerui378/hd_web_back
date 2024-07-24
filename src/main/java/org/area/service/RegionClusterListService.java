package org.area.service;

import jakarta.transaction.Transactional;
import org.area.dao.RegionClusterSubmitRepository;
import org.area.model.RegionClusterSubmit;
import org.area.vo.request.RegionClusterListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegionClusterListService {
    @Autowired
    private RegionClusterSubmitRepository repository;

    public List<RegionClusterSubmit> getAllRegionClusterSubmits() {
        return repository.findAll();
    }

    public RegionClusterSubmit getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public RegionClusterSubmit save(RegionClusterSubmit regionClusterSubmit) {
        return repository.save(regionClusterSubmit);
    }

    public void update(int id, RegionClusterSubmit regionClusterSubmit) {
        regionClusterSubmit.setId(id);
        repository.save(regionClusterSubmit);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }



}
