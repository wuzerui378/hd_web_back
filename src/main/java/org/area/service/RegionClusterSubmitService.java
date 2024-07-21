package org.area.service;
import jakarta.transaction.Transactional;
import org.area.dao.RegionClusterSubmitRepository;
import org.area.model.RegionClusterSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional  // 确保所有方法都在事务中执行
public class RegionClusterSubmitService {
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

    public void delete(int id) {
        repository.deleteById(id);
    }
}

