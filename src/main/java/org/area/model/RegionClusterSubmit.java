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
    private RegionCrowdType regionCrowdType;

    @Column(nullable = false)
    private int agentId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private int cleanMark;

}
