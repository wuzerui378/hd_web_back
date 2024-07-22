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

    @PostMapping
    public ApiResponse<String> createData(@RequestBody CombinedDataDTO combinedDataDTO) {
        regionClusterSubmitService.save(combinedDataDTO.getRegionClusterSubmits().get(0));
        areaListService.saveAll(combinedDataDTO.getAreaLists());
        customerDtoListService.saveAll(combinedDataDTO.getCustomerDtoLists());

        return ApiResponse.success("Data created successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateData(@PathVariable int id, @RequestBody CombinedDataDTO combinedDataDTO) {
        regionClusterSubmitService.update(id, combinedDataDTO.getRegionClusterSubmits().get(0));
        areaListService.updateAll(id, combinedDataDTO.getAreaLists());
        customerDtoListService.updateAll(id, combinedDataDTO.getCustomerDtoLists());

        return ApiResponse.success("Data updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteData(@PathVariable int id) {
        regionClusterSubmitService.delete(id);
        areaListService.deleteByRegionClusterSubmitId(id);
        customerDtoListService.deleteByRegionClusterId(id);

        return ApiResponse.success("Data deleted successfully");
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        return ApiResponse.fail(ResponseCode.SYSTEM_ERROR, e.getMessage());
    }
}





