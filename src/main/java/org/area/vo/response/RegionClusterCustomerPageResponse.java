package org.area.vo.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegionClusterCustomerPageResponse {
    private Integer code;
    private DataObject data;
    private String message;

    @Data
    public static class DataObject {
        private Integer page;
        private List<Row> rows;
        private Integer totalItems;
    }

    @Data
    public static class Row {
        private Integer id;
        private Integer regionClusterId;
        private Integer customerId;
        private String customerMobile;
        private String customerFullname;
        private LocalDateTime createTime;
    }
}
