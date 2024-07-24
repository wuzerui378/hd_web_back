package org.area.vo.response;

import lombok.Data;
import java.util.List;

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
    }
}
