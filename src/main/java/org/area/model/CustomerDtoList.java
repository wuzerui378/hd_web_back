package org.area.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_dto_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}