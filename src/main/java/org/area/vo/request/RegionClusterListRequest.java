package org.area.vo.request;

import lombok.Data;
import org.area.model.RegionClusterSubmit;

import java.util.List;

@Data
public class RegionClusterListRequest {
    private Integer agentId;
    private Integer id;
    private String regionClusterName;
    private String customerMobile;
    private List<String> statusList;
    // 转换为实体对象
    public RegionClusterSubmit toEntity() {
        RegionClusterSubmit entity = new RegionClusterSubmit();
        entity.setAgentId(this.agentId);
        entity.setId(this.id != null ? this.id : 0); // 默认值为0
        entity.setRegionClusterName(this.regionClusterName);
        // 其他字段可以根据需要进行设置
        return entity;
    }
}
