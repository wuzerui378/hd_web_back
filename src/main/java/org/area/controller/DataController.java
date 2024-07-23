package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.dto.CombinedDataDTO;
import org.area.commom.enums.ResponseCode;
import org.area.model.AreaList;
import org.area.model.CustomerDtoList;
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
        areaListService.save(combinedDataDTO.getAreaLists());
        customerDtoListService.save(combinedDataDTO.getCustomerDtoLists());

        return ApiResponse.success("Data created successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateData(@PathVariable int id, @RequestBody CombinedDataDTO combinedDataDTO) {
        regionClusterSubmitService.update(id, combinedDataDTO.getRegionClusterSubmits().get(0));
        areaListService.update(id, combinedDataDTO.getAreaLists());
        customerDtoListService.update(id, combinedDataDTO.getCustomerDtoLists());

        return ApiResponse.success("Data updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteData(@PathVariable int id) {
        regionClusterSubmitService.delete(id);
        areaListService.delete(id);
        customerDtoListService.delete(id);

        return ApiResponse.success("Data deleted successfully");
    }

    @GetMapping("/area/{id}")
    public ApiResponse<AreaList> getAreaById(@PathVariable int id) {
        var areaList = areaListService.getById(id);
        return ApiResponse.success(areaList);
    }

    @PostMapping("/area")
    public ApiResponse<String> createArea(@RequestBody AreaList areaList) {
        areaListService.save(Collections.singletonList(areaList));
        return ApiResponse.success("Area created successfully");
    }

    @PutMapping("/area/{id}")
    public ApiResponse<String> updateArea(@PathVariable int id, @RequestBody AreaList areaList) {
        areaListService.update(id, Collections.singletonList(areaList));
        return ApiResponse.success("Area updated successfully");
    }

    @DeleteMapping("/area/{id}")
    public ApiResponse<String> deleteArea(@PathVariable int id) {
        areaListService.delete(id);
        return ApiResponse.success("Area deleted successfully");
    }

    @GetMapping("/customer/{id}")
    public ApiResponse<CustomerDtoList> getCustomerById(@PathVariable int id) {
        var customer = customerDtoListService.getById(id);
        return ApiResponse.success(customer);
    }

    @PostMapping("/customer")
    public ApiResponse<String> createCustomer(@RequestBody CustomerDtoList customerDtoList) {
        customerDtoListService.save(Collections.singletonList(customerDtoList));
        return ApiResponse.success("Customer created successfully");
    }

    @PutMapping("/customer/{id}")
    public ApiResponse<String> updateCustomer(@PathVariable int id, @RequestBody CustomerDtoList customerDtoList) {
        customerDtoListService.update(id, Collections.singletonList(customerDtoList));
        return ApiResponse.success("Customer updated successfully");
    }

    @DeleteMapping("/customer/{id}")
    public ApiResponse<String> deleteCustomer(@PathVariable int id) {
        customerDtoListService.delete(id);
        return ApiResponse.success("Customer deleted successfully");
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        return ApiResponse.fail(ResponseCode.SYSTEM_ERROR, e.getMessage());
    }
}
