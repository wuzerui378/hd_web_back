package org.area.controller;

import jakarta.transaction.Transactional;
import org.area.service.RegionClusterSubmitService;
import org.area.service.AreaListService;
import org.area.service.CustomerDtoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.area.dto.CombinedDataDTO;

import java.util.Collections;  // 导入Collections工具类

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private RegionClusterSubmitService regionClusterSubmitService;
    @Autowired
    private AreaListService areaListService;
    @Autowired
    private CustomerDtoListService customerDtoListService;

    // 获取单个数据
    @Transactional
    @GetMapping("/{id}")
    public CombinedDataDTO getCombinedData(@PathVariable int id) {
        var regionClusterSubmit = regionClusterSubmitService.getById(id);
        var areaLists = areaListService.getByRegionClusterSubmitId(id);
        var customerDtoLists = customerDtoListService.getByRegionClusterId(id);

        // 包装单个 regionClusterSubmit 对象为列表
        return new CombinedDataDTO(
                Collections.singletonList(regionClusterSubmit),  // 将单个对象包装为列表
                areaLists,
                customerDtoLists);
    }

    // 返回所有数据
    @Transactional
    @GetMapping
    public CombinedDataDTO getAllData() {
        var allRegionClusterSubmits = regionClusterSubmitService.getAllRegionClusterSubmits();
        var allAreaLists = areaListService.getAllAreaLists();
        var allCustomerDtoLists = customerDtoListService.getAllCustomerDtoLists();
        return new CombinedDataDTO(
                allRegionClusterSubmits,
                allAreaLists,
                allCustomerDtoLists);
    }
}
