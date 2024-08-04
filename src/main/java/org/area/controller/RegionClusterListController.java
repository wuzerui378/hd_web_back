package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.model.CustomerDtoList;
import org.area.model.RegionClusterSubmit;
import org.area.service.RegionClusterListService;
import org.area.vo.request.RegionClusterListRequest;
import org.area.vo.response.RegionClusterListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regionClusterList")
public class RegionClusterListController {

    @Autowired
    private RegionClusterListService regionClusterListService;

    // 新增获取所有客户的API端点
    @GetMapping
    public ApiResponse<List<RegionClusterSubmit>> getAllRegionCluster() {
        List<RegionClusterSubmit> regionClusterSubmit = regionClusterListService.getAllRegionClusterSubmits();
        return ApiResponse.success(regionClusterSubmit);
    }

    // 请求：@RequestBody RegionClusterListRequest
    // 响应：ApiResponse<String>
    @PostMapping
    public ApiResponse<String> createRegionCluster(@RequestBody RegionClusterSubmit regionClusterSubmit) {
        regionClusterListService.save(regionClusterSubmit);
        return ApiResponse.success("Region cluster created successfully");
    }

    // 请求：@PathVariable int id
    // 响应：ApiResponse<RegionClusterListResponse>
    @GetMapping("/{id}")
    public ApiResponse<RegionClusterListResponse> getRegionCluster(@PathVariable int id) {
        RegionClusterSubmit regionClusterSubmit = regionClusterListService.getById(id);
        RegionClusterListResponse response = new RegionClusterListResponse(List.of(regionClusterSubmit));
        return ApiResponse.success(response);
    }


    // 请求：@PathVariable int id, @RequestBody RegionClusterSubmit
    // 响应：ApiResponse<String>
    @PutMapping("/{id}")
    public ApiResponse<String> updateRegionCluster(@PathVariable int id, @RequestBody RegionClusterSubmit regionClusterSubmit) {
        regionClusterListService.update(id, regionClusterSubmit);
        return ApiResponse.success("Region cluster updated successfully");
    }

    // 请求：@PathVariable int id
    // 响应：ApiResponse<String>
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRegionCluster(@PathVariable int id) {
        regionClusterListService.delete(id);
        return ApiResponse.success("Region cluster deleted successfully");
    }
}
