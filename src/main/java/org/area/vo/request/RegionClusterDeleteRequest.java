package org.area.vo.request;

import lombok.Data;
import java.util.List;

@Data
public class RegionClusterDeleteRequest {
    private Integer id;
    private List<Integer> ids;
}
