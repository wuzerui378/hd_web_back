package org.area;

import org.area.dao.AreaListRepository;
import org.area.dao.CustomerDtoListRepository;
import org.area.dao.RegionClusterSubmitRepository;
import org.area.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RegionClusterSubmitRepository regionClusterSubmitRepository;

    @Autowired
    private AreaListRepository areaListRepository;

    @Autowired
    private CustomerDtoListRepository customerDtoListRepository;

    @Override
    public void run(String... args) throws Exception {
        // 创建 RegionClusterSubmit 实例
        RegionClusterSubmit cluster = new RegionClusterSubmit();
        cluster.setRegionClusterName("Cluster Name");
        cluster.setRegionCrowdType(RegionCrowdType.CUSTOMER_LOCATION);
        cluster.setAgentId(1);
        cluster.setStatus(Status.ACTIVE);
        cluster.setCreatedBy("admin");
        cluster.setUpdatedBy("admin");
        cluster.setCreateTime(LocalDateTime.now());
        cluster.setUpdateTime(LocalDateTime.now());
        cluster.setCleanMark(0);
        regionClusterSubmitRepository.save(cluster);

        // 创建 AreaList 实例
        AreaList area = new AreaList();
        area.setRegionClusterSubmit(cluster);
        area.setAreaId(101);
        area.setProvinceId(10);
        area.setProvinceName("Province Name");
        area.setCityId(1001);
        area.setCityName("City Name");
        area.setDistrictId(10001);
        area.setDistrictName("District Name");
        area.setCreatedBy("admin");
        area.setUpdatedBy("admin");
        area.setCreateTime(LocalDateTime.now());
        area.setUpdateTime(LocalDateTime.now());
        areaListRepository.save(area);

        // 创建 CustomerDtoList 实例
        CustomerDtoList customer = new CustomerDtoList();
        customer.setRegionClusterSubmit(cluster);
        customer.setCustomerId(10001);
        customer.setCreateTime(LocalDateTime.now());
        customer.setAgentId(1);
        customer.setAgentName("Agent Name");
        customer.setCustomerMobile("1234567890");
        customer.setCustomerFullname("Customer Name");
        customerDtoListRepository.save(customer);
    }
}
