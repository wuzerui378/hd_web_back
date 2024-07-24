package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.service.RegionClusterSubmitService;
import org.area.vo.request.RegionClusterSubmitRequest;
import org.area.vo.response.RegionClusterSubmitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regionCluster")
public class RegionClusterSubmitController {

    @Autowired
    private RegionClusterSubmitService regionClusterSubmitService;

    // 请求：@RequestBody RegionClusterSubmitRequest
    // 响应：ApiResponse<String>
    @PostMapping
    public ApiResponse<String> createRegionCluster(@RequestBody RegionClusterSubmitRequest request) {
        regionClusterSubmitService.save(request.toEntity());
        return ApiResponse.success("Region cluster created successfully");
    }

    // 请求：@PathVariable int id
    // 响应：ApiResponse<RegionClusterSubmitResponse>
    @GetMapping("/{id}")
    public ApiResponse<RegionClusterSubmitResponse> getRegionCluster(@PathVariable int id) {
        var regionClusterSubmit = regionClusterSubmitService.getById(id);
        return ApiResponse.success(new RegionClusterSubmitResponse(regionClusterSubmit));
    }

    // 请求：@PathVariable int id, @RequestBody RegionClusterSubmitRequest
    // 响应：ApiResponse<String>
    @PutMapping("/{id}")
    public ApiResponse<String> updateRegionCluster(@PathVariable int id, @RequestBody RegionClusterSubmitRequest request) {
        regionClusterSubmitService.update(id, request.toEntity());
        return ApiResponse.success("Region cluster updated successfully");
    }

    // 请求：@PathVariable int id
    // 响应：ApiResponse<String>
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRegionCluster(@PathVariable int id) {
        regionClusterSubmitService.delete(id);
        return ApiResponse.success("Region cluster deleted successfully");
    }
}
