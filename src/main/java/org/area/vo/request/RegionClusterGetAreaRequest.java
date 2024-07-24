package org.area.vo.request;

import lombok.Data;

@Data
public class RegionClusterGetAreaRequest {
    private Integer agentId;
    private Integer page;
    private Integer rows;
    private Integer id;
    private Integer areaLevel;
    private String areaCode;
    private String areaName;

}
