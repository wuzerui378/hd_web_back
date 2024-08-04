package org.area.vo.response;

import lombok.Data;
import org.area.model.AreaList;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class RegionClusterGetAreaResponse {
    private Integer code;
    private List<DataObject> data;
    private String message;

    @Data
    public static class DataObject {
        private Integer id;
        private String regionClusterName;
        private String areaCode;
        private String areaName;
        private Integer areaLevel;
        private String letter;
        private Integer parentId;
        private Integer agentId;

        // 构造函数，接受实体对象
        public DataObject(AreaList entity) {
            this.id = entity.getId();
            this.regionClusterName = entity.getRegionClusterName();
            this.areaCode = entity.getAreaCode();
            this.areaName = entity.getAreaName();
            this.areaLevel = entity.getAreaLevel();
            this.parentId = entity.getParentId();
            this.agentId = entity.getAgentId();
        }
    }

    // 构造函数，接受实体对象列表
    public RegionClusterGetAreaResponse(List<AreaList> entities) {
        this.data = entities.stream().map(DataObject::new).collect(Collectors.toList());
    }
}
