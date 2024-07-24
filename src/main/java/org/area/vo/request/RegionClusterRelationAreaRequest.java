package org.area.vo.request;

import lombok.Data;
import org.area.model.AreaList;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegionClusterRelationAreaRequest {
    private Integer agentId;
    private Integer page;
    private Integer offset;
    private Integer rows;
    private String regionClusterName;
    private String customerMobile;
    private List<String> statusList;
    private Integer id;
    private Integer provinceId;
    private String provinceName;
    private Integer cityId;
    private String cityName;
    private Integer districtId;
    private String districtName;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 转换为实体对象
    public AreaList toEntity() {
        AreaList areaList = new AreaList();
        areaList.setId(this.id != null ? this.id : 0);
        areaList.setRegionClusterId(this.agentId != null ? this.agentId : 0); // 假设 agentId 是 regionClusterId
        areaList.setProvinceId(this.provinceId != null ? this.provinceId : 0);
        areaList.setProvinceName(this.provinceName != null ? this.provinceName : "");
        areaList.setCityId(this.cityId != null ? this.cityId : 0);
        areaList.setCityName(this.cityName != null ? this.cityName : "");
        areaList.setDistrictId(this.districtId != null ? this.districtId : 0);
        areaList.setDistrictName(this.districtName != null ? this.districtName : "");
        areaList.setCreatedBy(this.createdBy != null ? this.createdBy : "");
        areaList.setUpdatedBy(this.updatedBy != null ? this.updatedBy : "");
        areaList.setCreateTime(this.createTime != null ? this.createTime : LocalDateTime.now());
        areaList.setUpdateTime(this.updateTime != null ? this.updateTime : LocalDateTime.now());
        return areaList;
    }


}
