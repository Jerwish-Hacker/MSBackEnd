package com.ms_perfume.ms_perfume.controller;


import com.ms_perfume.ms_perfume.dto.LoginResponse;
import com.ms_perfume.ms_perfume.entity.Purchase;
import com.ms_perfume.ms_perfume.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchase")
@CrossOrigin
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;
    @PostMapping("/create")
    public List<Purchase> addpurchase(@RequestBody List<Purchase> purchases) {
        return purchaseService.addPurchase(purchases);
    }


    @GetMapping("/sales")
    public List<String> salesfetcher() {
        return purchaseService.salesFetcher();
    }


    @GetMapping("/sales/subname")
    public List<String> salesFetcherSubName(@RequestParam String keyword ) {
        return purchaseService.salesFetcherSubName(keyword);
    }

    @GetMapping("/sales/quantity")
    public List<String> salesFetcherquantity(@RequestParam String p_name , String p_sub_name ) {
        return purchaseService.salesFetcherQuantity(p_name,p_sub_name);
    }
}
