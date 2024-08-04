package org.area.vo.response;

import lombok.Data;
import org.area.model.CustomerDtoList;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        private Integer agentId;
        private String agentName;
        private String customerMobile;
        private String customerFullname;
        private LocalDateTime createTime;

        // 构造函数，接受 CustomerDtoList 对象
        public Row(CustomerDtoList entity) {
            this.id = entity.getId();
            this.regionClusterId = entity.getRegionClusterId();
            this.customerId = entity.getCustomerId();
            this.agentId = entity.getAgentId();
            this.agentName = entity.getAgentName();
            this.customerMobile = entity.getCustomerMobile();
            this.customerFullname = entity.getCustomerFullname();
            this.createTime = entity.getCreateTime();
        }
    }

    // 构造函数，接受列表
    public RegionClusterCustomerPageResponse(List<CustomerDtoList> customers) {
        this.code = 0; // 设置默认值
        this.data = new DataObject();
        this.data.rows = customers.stream().map(Row::new).collect(Collectors.toList());
        this.message = "Success"; // 设置默认值
    }
}
