package org.area.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_dto_list")
public class CustomerDtoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 添加 regionClusterId 属性
    @Column(nullable = false)
    private int regionClusterId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private int agentId;

    @Column(nullable = false, length = 255)
    private String agentName;

    @Column(nullable = false, length = 20)
    private String customerMobile;

    @Column(nullable = false, length = 255)
    private String customerFullname;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }



    public int getRegionClusterId() {
        return regionClusterId;
    }

    public void setRegionClusterId(int regionClusterId) {
        this.regionClusterId = regionClusterId;
    }


    // Getters and setters...
}

