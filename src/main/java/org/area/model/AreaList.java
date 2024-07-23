package org.area.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "area_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 添加 regionClusterId 属性
    @Column(name = "region_cluster_id", nullable = false)
    private int regionClusterId;


    @Column(nullable = false)
    private int areaId;

    @Column(nullable = false)
    private int provinceId;

    @Column(nullable = false, length = 255)
    private String provinceName;

    @Column(nullable = false)
    private int cityId;

    @Column(nullable = false, length = 255)
    private String cityName;

    @Column(nullable = false)
    private int districtId;

    @Column(nullable = false, length = 255)
    private String districtName;

    @Column(nullable = false, length = 255)
    private String createdBy;

    @Column(nullable = false, length = 255)
    private String updatedBy;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//
//    public int getAreaId() {
//        return areaId;
//    }
//
//    public void setAreaId(int areaId) {
//        this.areaId = areaId;
//    }
//
//    public int getProvinceId() {
//        return provinceId;
//    }
//
//    public void setProvinceId(int provinceId) {
//        this.provinceId = provinceId;
//    }
//
//    public String getProvinceName() {
//        return provinceName;
//    }
//
//    public void setProvinceName(String provinceName) {
//        this.provinceName = provinceName;
//    }
//
//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }
//
//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//
//    public int getDistrictId() {
//        return districtId;
//    }
//
//    public void setDistrictId(int districtId) {
//        this.districtId = districtId;
//    }
//
//    public String getDistrictName() {
//        return districtName;
//    }
//
//    public void setDistrictName(String districtName) {
//        this.districtName = districtName;
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
//
//    public int getRegionClusterId() {
//        return regionClusterId;
//    }
//
//    public void setRegionClusterId(int regionClusterId) {
//        this.regionClusterId = regionClusterId;
//    }
// Getters and setters...
}
