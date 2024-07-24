package org.area.vo.request;

import lombok.Data;
import java.util.List;

@Data
public class RegionClusterRelationAreaRequest {
    private Integer agentId;
    private Integer page;
    private Integer offset;
    private Integer rows;
    private OrderBy orderBy;
    private Integer id;
    private String regionClusterName;
    private String customerMobile;
    private List<String> statusList;

    @Data
    public static class OrderBy {
        private String column;
        private Boolean asc;
    }
}
