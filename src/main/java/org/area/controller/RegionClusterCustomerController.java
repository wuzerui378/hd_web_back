package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.model.CustomerDtoList;
import org.area.service.CustomerDtoListService;
import org.area.vo.request.RegionClusterCustomerPageRequest;
import org.area.vo.response.RegionClusterCustomerPageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regionClusterCustomer")
public class RegionClusterCustomerController {

    @Autowired
    private CustomerDtoListService customerDtoListService;

    // 新增获取所有客户的API端点
    @GetMapping
    public ApiResponse<List<CustomerDtoList>> getAllCustomers() {
        List<CustomerDtoList> customers = customerDtoListService.getAllCustomers();
        return ApiResponse.success(customers);
    }

    // 创建骑手
    @PostMapping("/create")
    public ApiResponse<String> createCustomer(@RequestBody RegionClusterCustomerPageRequest request) {
        CustomerDtoList customer = request.toEntity();
        customerDtoListService.save(customer);
        return ApiResponse.success("Customer created successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<RegionClusterCustomerPageResponse> getCustomer(@PathVariable int id) {
        CustomerDtoList customer = customerDtoListService.getById(id);
        RegionClusterCustomerPageResponse response = new RegionClusterCustomerPageResponse(List.of(customer));
        return ApiResponse.success(response);
    }



    @PutMapping("/{id}")
    public ApiResponse<String> updateCustomer(@PathVariable int id, @RequestBody RegionClusterCustomerPageRequest request) {
        CustomerDtoList customer = request.toEntity();
        customerDtoListService.update(id, customer);
        return ApiResponse.success("Customer updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteCustomer(@PathVariable int id) {
        customerDtoListService.delete(id);
        return ApiResponse.success("Customer deleted successfully");
    }
}
