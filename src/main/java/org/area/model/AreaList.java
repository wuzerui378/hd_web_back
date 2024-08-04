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

    @Column(name = "region_cluster_id", nullable = false)
    private int regionClusterId;

    @Column(nullable = false, length = 255)
    private String regionClusterName;

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

    @Column(nullable = false)
    private int agentId;

    @Column(nullable = false)
    private int areaLevel;

    @Column(nullable = false, length = 6)
    private String areaCode;

    @Column(nullable = false, length = 255)
    private String areaName;

    @Column(nullable = false)
    private int parentId;
}
