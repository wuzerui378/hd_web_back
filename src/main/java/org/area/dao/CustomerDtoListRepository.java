package org.area.dao;

import jakarta.transaction.Transactional;
import org.area.model.CustomerDtoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CustomerDtoListRepository extends JpaRepository<CustomerDtoList, Integer> {
    //List<CustomerDtoList> findByRegionClusterId(int regionClusterId); // 修改查询方法名称

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM CustomerDtoList c WHERE c.regionClusterId = :regionClusterId")
//    void deleteByRegionClusterId(@Param("regionClusterId") int regionClusterId);

}
