package com.ms_perfume.ms_perfume.controller;


import com.ms_perfume.ms_perfume.entity.Vendor;
import com.ms_perfume.ms_perfume.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    public  Vendor addVendor(@RequestBody Vendor vendor){
          return   this.vendorService.addVendor(vendor);
    }



}
