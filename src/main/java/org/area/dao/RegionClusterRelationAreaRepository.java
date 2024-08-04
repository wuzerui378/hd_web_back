package org.area.dao;

import org.area.model.AreaList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionClusterRelationAreaRepository extends JpaRepository<AreaList, Integer> {
    //List<AreaList> findByRegionClusterId(Integer regionClusterId);
}
