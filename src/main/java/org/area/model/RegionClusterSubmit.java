package org.area.model;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.area.commom.enums.RegionCrowdType;
import org.area.commom.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "region_cluster_submit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionClusterSubmit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String regionClusterName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegionCrowdType regionCrowdType;

    @Column(nullable = false)
    private int agentId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false, length = 255)
    private String createdBy;

    @Column(nullable = false, length = 255)
    private String updatedBy;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;

    @Column(nullable = false)
    private int cleanMark;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getRegionClusterName() {
//        return regionClusterName;
//    }
//
//    public void setRegionClusterName(String regionClusterName) {
//        this.regionClusterName = regionClusterName;
//    }
//
//    public RegionCrowdType getRegionCrowdType() {
//        return regionCrowdType;
//    }
//
//    public void setRegionCrowdType(RegionCrowdType regionCrowdType) {
//        this.regionCrowdType = regionCrowdType;
//    }
//
//    public int getAgentId() {
//        return agentId;
//    }
//
//    public void setAgentId(int agentId) {
//        this.agentId = agentId;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }
//
//    public LocalDateTime getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(LocalDateTime updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public int getCleanMark() {
//        return cleanMark;
//    }
//
//    public void setCleanMark(int cleanMark) {
//        this.cleanMark = cleanMark;
//    }




}
