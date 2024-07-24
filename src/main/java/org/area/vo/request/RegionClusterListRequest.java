package org.area.vo.request;

import lombok.Data;

import java.util.List;

@Data
public class RegionClusterListRequest {
    private Integer agentId;
    private Integer id;
    private String regionClusterName;
    private String customerMobile;
    private List<String> statusList;
}
