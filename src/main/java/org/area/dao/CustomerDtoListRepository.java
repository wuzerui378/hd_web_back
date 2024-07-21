package org.area.dao;

import org.area.model.CustomerDtoList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CustomerDtoListRepository extends JpaRepository<CustomerDtoList, Integer> {
    List<CustomerDtoList> findByRegionClusterId(int regionClusterId); // 修改查询方法名称
}
