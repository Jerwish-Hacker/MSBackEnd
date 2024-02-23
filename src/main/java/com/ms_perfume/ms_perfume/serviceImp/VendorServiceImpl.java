package com.ms_perfume.ms_perfume.serviceImp;

import com.ms_perfume.ms_perfume.entity.Vendor;
import com.ms_perfume.ms_perfume.repo.VendorRepository;
import com.ms_perfume.ms_perfume.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor addVendor(Vendor vendor) {
        return this.vendorRepository.save(vendor);
    }
}
