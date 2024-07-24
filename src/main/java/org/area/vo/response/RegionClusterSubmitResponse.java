package org.area.vo.response;

import lombok.Data;
import org.area.model.RegionClusterSubmit;

@Data
public class RegionClusterSubmitResponse {
    private int id;
    private String regionClusterName;
    private String regionCrowdType;
    private int agentId;
    private String status;
    private String createdBy;
    private String updatedBy;

    public RegionClusterSubmitResponse(RegionClusterSubmit entity) {
        this.id = entity.getId();
        this.regionClusterName = entity.getRegionClusterName();
        this.regionCrowdType = entity.getRegionCrowdType().name(); // 将枚举类型转换为字符串
        this.agentId = entity.getAgentId();
        this.status = entity.getStatus().name(); // 将枚举类型转换为字符串
        this.createdBy = entity.getCreatedBy();
        this.updatedBy = entity.getUpdatedBy();
    }
}
