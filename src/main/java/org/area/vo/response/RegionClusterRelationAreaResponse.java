package org.area.vo.response;

import lombok.Data;
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
    }
}
