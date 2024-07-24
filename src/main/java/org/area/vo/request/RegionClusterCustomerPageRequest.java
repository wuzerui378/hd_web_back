package org.area.vo.request;

import lombok.Data;

import java.util.List;

@Data
public class RegionClusterCustomerPageRequest {
    private Integer agentId;
    private Integer page;
    private Integer id;
    private String regionClusterName;
    private String customerMobile;
    private List<String> statusList;


}
