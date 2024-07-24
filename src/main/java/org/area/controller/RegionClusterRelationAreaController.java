package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.service.RegionClusterRelationAreaService;
import org.area.vo.request.RegionClusterRelationAreaRequest;
import org.area.vo.response.RegionClusterRelationAreaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regionClusterRelationArea")
public class RegionClusterRelationAreaController {

    @Autowired
    private RegionClusterRelationAreaService regionClusterRelationAreaService;

    // 请求：@RequestBody RegionClusterRelationAreaRequest
    // 响应：ApiResponse<String>
    @PostMapping
    public ApiResponse<String> createRegionClusterRelationArea(@RequestBody RegionClusterRelationAreaRequest request) {
        regionClusterRelationAreaService.save(request.toEntity());
        return ApiResponse.success("Region cluster relation area created successfully");
    }

    // 请求：@PathVariable int id
    // 响应：ApiResponse<RegionClusterRelationAreaResponse>
    @GetMapping("/{id}")
    public ApiResponse<RegionClusterRelationAreaResponse> getRegionClusterRelationArea(@PathVariable int id) {
        var areaList = regionClusterRelationAreaService.getById(id);
        return ApiResponse.success(new RegionClusterRelationAreaResponse(0, List.of(areaList), "Success"));
    }

    // 请求：@PathVariable int id, @RequestBody RegionClusterRelationAreaRequest
    // 响应：ApiResponse<String>
    @PutMapping("/{id}")
    public ApiResponse<String> updateRegionClusterRelationArea(@PathVariable int id, @RequestBody RegionClusterRelationAreaRequest request) {
        regionClusterRelationAreaService.update(id, request.toEntity());
        return ApiResponse.success("Region cluster relation area updated successfully");
    }

    // 请求：@PathVariable int id
    // 响应：ApiResponse<String>
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRegionClusterRelationArea(@PathVariable int id) {
        regionClusterRelationAreaService.delete(id);
        return ApiResponse.success("Region cluster relation area deleted successfully");
    }
}
