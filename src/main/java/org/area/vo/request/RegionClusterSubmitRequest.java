package org.area.vo.request;

import lombok.Data;
import org.area.model.RegionClusterSubmit;
import org.area.commom.enums.RegionCrowdType;
import org.area.commom.enums.Status;

@Data
public class RegionClusterSubmitRequest {
    private String regionClusterName;
    private String regionCrowdType;
    private int agentId;
    private String status;
    private String createdBy;
    private String updatedBy;

    // 转换为实体对象
    public RegionClusterSubmit toEntity() {
        RegionClusterSubmit entity = new RegionClusterSubmit();
        entity.setRegionClusterName(this.regionClusterName);
        entity.setRegionCrowdType(RegionCrowdType.valueOf(this.regionCrowdType)); // 转换为枚举类型
        entity.setAgentId(this.agentId);
        entity.setStatus(Status.valueOf(this.status)); // 转换为枚举类型
        entity.setCreatedBy(this.createdBy);
        entity.setUpdatedBy(this.updatedBy);
        return entity;
    }
}
