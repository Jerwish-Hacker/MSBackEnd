package com.ms_perfume.ms_perfume.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sales_master")
@Data
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String pName;

    @Column(nullable = false)
    private String pSubName;

    @Column(nullable = false)
    private String ppp;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private String mrp;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String createdBy;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSubName() {
        return pSubName;
    }

    public void setpSubName(String pSubName) {
        this.pSubName = pSubName;
    }

    public String getPpp() {
        return ppp;
    }

    public void setPpp(String ppp) {
        this.ppp = ppp;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
