package org.area.vo.request;

import lombok.Data;

@Data
public class RegionClusterGetAreaRequest {
    private Integer agentId;
    private Integer page;
    private Integer offset;
    private Integer rows;
    private OrderBy orderBy;
    private Integer id;
    private Integer areaLevel;
    private String areaCode;
    private String areaName;

    @Data
    public static class OrderBy {
        private String column;
        private Boolean asc;
    }
}
