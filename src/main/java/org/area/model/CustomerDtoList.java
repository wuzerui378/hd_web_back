package org.area.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_dto_list")
public class CustomerDtoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_cluster_id", nullable = false)
    private RegionClusterSubmit regionClusterSubmit;

    @Column(nullable = false)
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RegionClusterSubmit getRegionClusterSubmit() {
        return regionClusterSubmit;
    }

    public void setRegionClusterSubmit(RegionClusterSubmit regionClusterSubmit) {
        this.regionClusterSubmit = regionClusterSubmit;
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



    // Getters and setters...
}

