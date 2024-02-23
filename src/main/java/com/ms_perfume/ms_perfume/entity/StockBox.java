package com.ms_perfume.ms_perfume.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "stock_box")

public class StockBox {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String pName;

    @Column(nullable = false)
    private String pSubName;

    @Column(nullable = false)
    private String quantity;
}
