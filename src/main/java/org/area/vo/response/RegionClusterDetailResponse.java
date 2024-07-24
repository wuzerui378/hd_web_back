package org.area.vo.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegionClusterDetailResponse {
    private Integer code;
    private DataObject data;
    private String message;

    @Data
    public static class DataObject {
        private Integer id;
        private String regionClusterName;
        private String regionCrowdType;
        private Integer agentId;
        private String status;
        private String createdBy;
        private String updatedBy;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
        private List<Area> areaList;
    }

    @Data
    public static class Area {
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
