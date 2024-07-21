package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.dto.CombinedDataDTO;
import org.area.commom.enums.ResponseCode;
import org.area.service.RegionClusterSubmitService;
import org.area.service.AreaListService;
import org.area.service.CustomerDtoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private RegionClusterSubmitService regionClusterSubmitService;
    @Autowired
    private AreaListService areaListService;
    @Autowired
    private CustomerDtoListService customerDtoListService;

    @GetMapping("/{id}")
    public ApiResponse<CombinedDataDTO> getCombinedData(@PathVariable int id) {
        var regionClusterSubmit = regionClusterSubmitService.getById(id);
        var areaLists = areaListService.getByRegionClusterSubmitId(id);
        var customerDtoLists = customerDtoListService.getByRegionClusterId(id);

        CombinedDataDTO combinedData = new CombinedDataDTO(
                Collections.singletonList(regionClusterSubmit),
                areaLists,
                customerDtoLists);

        return ApiResponse.success(combinedData);
    }

    @GetMapping
    public ApiResponse<CombinedDataDTO> getAllData() {
        var allRegionClusterSubmits = regionClusterSubmitService.getAllRegionClusterSubmits();
        var allAreaLists = areaListService.getAllAreaLists();
        var allCustomerDtoLists = customerDtoListService.getAllCustomerDtoLists();

        CombinedDataDTO combinedData = new CombinedDataDTO(
                allRegionClusterSubmits,
                allAreaLists,
                allCustomerDtoLists);

        return ApiResponse.success(combinedData);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        return ApiResponse.fail(ResponseCode.SYSTEM_ERROR, e.getMessage());
    }
}

//package org.area.controller;
//
//import org.area.service.RegionClusterSubmitService;
//import org.area.service.AreaListService;
//import org.area.service.CustomerDtoListService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.area.dto.CombinedDataDTO;
//
//import java.util.Collections;  // 导入Collections工具类
//
//@RestController
//@RequestMapping("/api/data")
//public class DataController {
//
//    @Autowired
//    private RegionClusterSubmitService regionClusterSubmitService;
//    @Autowired
//    private AreaListService areaListService;
//    @Autowired
//    private CustomerDtoListService customerDtoListService;
//
//    // 获取单个数据
//
//    @GetMapping("/{id}")
//    public CombinedDataDTO getCombinedData(@PathVariable int id) {
//        var regionClusterSubmit = regionClusterSubmitService.getById(id);
//        var areaLists = areaListService.getByRegionClusterSubmitId(id);
//        var customerDtoLists = customerDtoListService.getByRegionClusterId(id);
//
//        // 包装单个 regionClusterSubmit 对象为列表
//        return new CombinedDataDTO(
//                Collections.singletonList(regionClusterSubmit),  // 将单个对象包装为列表
//                areaLists,
//                customerDtoLists);
//    }
//
//    // 返回所有数据
//    @GetMapping
//    public CombinedDataDTO getAllData() {
//        var allRegionClusterSubmits = regionClusterSubmitService.getAllRegionClusterSubmits();
//        var allAreaLists = areaListService.getAllAreaLists();
//        var allCustomerDtoLists = customerDtoListService.getAllCustomerDtoLists();
//        return new CombinedDataDTO(
//                allRegionClusterSubmits,
//                allAreaLists,
//                allCustomerDtoLists);
//    }
//}
