package org.area;

import org.area.commom.enums.RegionCrowdType;
import org.area.commom.enums.Status;
import org.area.dao.AreaListRepository;
import org.area.dao.CustomerDtoListRepository;
import org.area.dao.RegionClusterSubmitRepository;
import org.area.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

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
        // 检查 RegionClusterSubmit 数据是否存在
        Optional<RegionClusterSubmit> existingCluster = regionClusterSubmitRepository.findById(1);
        if (existingCluster.isEmpty()) {
            // 创建 RegionClusterSubmit 实例
            RegionClusterSubmit cluster = new RegionClusterSubmit();
            cluster.setRegionClusterName("余杭区");
            cluster.setRegionCrowdType(RegionCrowdType.CUSTOMER_LOCATION);
            cluster.setAgentId(1);
            cluster.setStatus(Status.ACTIVE);
            cluster.setCreatedBy("管理员");
            cluster.setUpdatedBy("管理员");
            cluster.setCreateTime(LocalDateTime.now());
            cluster.setUpdateTime(LocalDateTime.now());
            cluster.setCleanMark(0);
            regionClusterSubmitRepository.save(cluster);

            // 创建 AreaList 实例
            AreaList area = new AreaList();
            area.setAreaId(101);
            area.setRegionClusterId(1);
            area.setProvinceId(10);
            area.setProvinceName("浙江省");
            area.setCityId(1001);
            area.setCityName("杭州市");
            area.setDistrictId(10001);
            area.setDistrictName("西湖区");
            area.setCreatedBy("管理员");
            area.setUpdatedBy("管理员");
            area.setCreateTime(LocalDateTime.now());
            area.setUpdateTime(LocalDateTime.now());
            areaListRepository.save(area);

            // 创建 CustomerDtoList 实例
            CustomerDtoList customer = new CustomerDtoList();
            customer.setCustomerId(10001);
            customer.setRegionClusterId(1);
            customer.setCreateTime(LocalDateTime.now());
            customer.setAgentId(1);
            customer.setAgentName("管理员");
            customer.setCustomerMobile("1234567890");
            customer.setCustomerFullname("张三");
            customerDtoListRepository.save(customer);
        }
    }
}
