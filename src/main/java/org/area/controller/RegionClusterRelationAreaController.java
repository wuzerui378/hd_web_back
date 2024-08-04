package org.area.controller;

import org.area.dto.ApiResponse;
import org.area.model.AreaList;
import org.area.service.RegionClusterRelationAreaService;
import org.area.vo.request.RegionClusterRelationAreaRequest;
import org.area.vo.response.RegionClusterRelationAreaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areaList")

public class RegionClusterRelationAreaController {

    @Autowired
    private RegionClusterRelationAreaService regionClusterRelationAreaService;

    // 新增获取所有客户的API端点
    @GetMapping
    public ApiResponse<List<AreaList>> getAllAreas() {
        List<AreaList> areas = regionClusterRelationAreaService.getAllAreaLists();
        return ApiResponse.success(areas);
    }

    @PostMapping("/create")
    public ApiResponse<String> createRegionClusterRelationArea(@RequestBody RegionClusterRelationAreaRequest request) {
        AreaList areas = request.toEntity();
        regionClusterRelationAreaService.save(areas);
        return ApiResponse.success("Region cluster relation area created successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<RegionClusterRelationAreaResponse> getRegionClusterRelationArea(@PathVariable int id) {
        var areaList = regionClusterRelationAreaService.getById(id);
        return ApiResponse.success(new RegionClusterRelationAreaResponse(0, List.of(areaList), "Success"));
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateRegionClusterRelationArea(@PathVariable int id, @RequestBody RegionClusterRelationAreaRequest request) {
        regionClusterRelationAreaService.update(id, request.toEntity());
        return ApiResponse.success("Region cluster relation area updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRegionClusterRelationArea(@PathVariable int id) {
        regionClusterRelationAreaService.delete(id);
        return ApiResponse.success("Region cluster relation area deleted successfully");
    }
}
