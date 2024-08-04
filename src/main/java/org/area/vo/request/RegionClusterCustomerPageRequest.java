package org.area.vo.request;

import lombok.Data;
import org.area.model.CustomerDtoList;

import java.time.LocalDateTime;

@Data
public class RegionClusterCustomerPageRequest {
    private Integer regionClusterId;
    private Integer customerId;
    private Integer agentId;
    private String agentName;
    private String customerMobile;
    private String customerFullname;
    private LocalDateTime createTime;

    // 转换为实体对象
    public CustomerDtoList toEntity() {
        CustomerDtoList entity = new CustomerDtoList();
        entity.setRegionClusterId(this.regionClusterId);
        entity.setCustomerId(this.customerId);
        entity.setAgentId(this.agentId);
        entity.setAgentName(this.agentName);
        entity.setCustomerMobile(this.customerMobile);
        entity.setCustomerFullname(this.customerFullname);
        entity.setCreateTime(this.createTime);
        return entity;
    }
}
