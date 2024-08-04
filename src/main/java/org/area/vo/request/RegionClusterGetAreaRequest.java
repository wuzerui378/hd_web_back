package org.area.vo.request;

import lombok.Data;
import org.area.model.AreaList;


@Data
public class RegionClusterGetAreaRequest {
    private Integer agentId;
//    private Integer page;
//    private Integer rows;
    private Integer id;
    private Integer areaLevel;
    private String areaCode;
    private String areaName;
    // 转换为实体对象
    public AreaList toEntity() {
        AreaList entity = new AreaList();
        entity.setAgentId(this.agentId);
        entity.setId(this.id);
        entity.setAreaLevel(this.areaLevel);
        entity.setAreaCode(this.areaCode);
        entity.setAreaName(this.areaName);
        return entity;
    }

}
