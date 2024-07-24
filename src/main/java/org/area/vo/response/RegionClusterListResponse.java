package org.area.vo.response;

import lombok.Data;
import org.area.model.RegionClusterSubmit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

        // 构造函数，接受实体对象列表
        public DataObject(List<RegionClusterSubmit> entities) {
            this.rows = entities.stream().map(Row::new).collect(Collectors.toList());
        }
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

        // 构造函数，接受实体对象
        public Row(RegionClusterSubmit entity) {
            this.id = entity.getId();
            this.regionClusterName = entity.getRegionClusterName();
            this.regionCrowdType = entity.getRegionCrowdType().name(); // 将枚举类型转换为字符串
            this.agentId = entity.getAgentId();
            this.status = entity.getStatus().name(); // 将枚举类型转换为字符串
            this.createdBy = entity.getCreatedBy();
            this.updatedBy = entity.getUpdatedBy();
            this.createTime = entity.getCreateTime();
            this.updateTime = entity.getUpdateTime();
            // 假设有其他字段可以在这里进行设置
        }
    }

    // 构造函数，接受实体对象列表
    public RegionClusterListResponse(List<RegionClusterSubmit> entities) {
        this.data = new DataObject(entities);
    }
}
