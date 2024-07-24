package org.area.vo.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegionClusterListResponse {
    private Integer code;
    private DataObject data;
    private String message;

    @Data
    public static class DataObject {
        private Integer page;
        private List<Row> rows;
        private Integer totalItems;
    }

    @Data
    public static class Row {
        private Integer id;
        private String regionClusterName;
        private String regionCrowdType;
        private Integer agentId;
        private String agentName;
        private String status;
        private String statusName;
        private Integer areaNum;
        private Integer customerNum;
        private String createdBy;
        private String updatedBy;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
    }
}
