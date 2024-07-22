package org.area.dao;

import jakarta.transaction.Transactional;
import org.area.model.AreaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AreaListRepository extends JpaRepository<AreaList, Integer> {
    List<AreaList> findByRegionClusterId(int regionClusterId); // 修改查询方法名称

    @Modifying
    @Transactional
    @Query("DELETE FROM AreaList a WHERE a.regionClusterId = :regionClusterSubmitId")
    void deleteByRegionClusterSubmitId(@Param("regionClusterSubmitId") int regionClusterSubmitId);
}
