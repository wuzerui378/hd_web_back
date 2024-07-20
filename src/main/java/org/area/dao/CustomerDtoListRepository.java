package org.area.dao;

import org.area.model.CustomerDtoList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CustomerDtoListRepository extends JpaRepository<CustomerDtoList, Integer> {
    List<CustomerDtoList> findByRegionClusterSubmit_Id(int regionClusterSubmitId);
}
