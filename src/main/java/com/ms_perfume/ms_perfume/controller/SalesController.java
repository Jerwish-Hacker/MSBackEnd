package com.ms_perfume.ms_perfume.controller;


import com.ms_perfume.ms_perfume.entity.Sales;
import com.ms_perfume.ms_perfume.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/sales")
public class SalesController {
    @Autowired
    SalesService salesService;

    @PostMapping("/add")
    public List<Sales> addSales(@RequestBody List<Sales> sales){
        return this.salesService.addSales(sales);
    }
}
