package org.area.vo.response;

import lombok.Data;
import org.area.model.AreaList;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegionClusterRelationAreaResponse {
    private Integer code;
    private List<DataObject> data;
    private String message;

    @Data
    public static class DataObject {
        private Integer id;
        private Integer regionClusterId;
        private Integer areaId;
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

        // 构造函数，接受 AreaList 对象
        public DataObject(AreaList areaList) {
            this.id = areaList.getId();
            this.regionClusterId = areaList.getRegionClusterId();
            this.areaId = areaList.getAreaId();
            this.provinceId = areaList.getProvinceId();
            this.provinceName = areaList.getProvinceName();
            this.cityId = areaList.getCityId();
            this.cityName = areaList.getCityName();
            this.districtId = areaList.getDistrictId();
            this.districtName = areaList.getDistrictName();
            this.createdBy = areaList.getCreatedBy();
            this.updatedBy = areaList.getUpdatedBy();
            this.createTime = areaList.getCreateTime();
            this.updateTime = areaList.getUpdateTime();
        }
    }

    // 构造函数，接受列表
    public RegionClusterRelationAreaResponse(Integer code, List<AreaList> areaLists, String message) {
        this.code = code;
        this.data = areaLists.stream().map(DataObject::new).toList();
        this.message = message;
    }
}
