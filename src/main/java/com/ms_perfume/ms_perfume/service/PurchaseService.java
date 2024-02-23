package com.ms_perfume.ms_perfume.service;

import com.ms_perfume.ms_perfume.dto.LoginResponse;
import com.ms_perfume.ms_perfume.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    List<Purchase> addPurchase(List<Purchase> purchase);

    List<String> salesFetcher();
    List<String> salesFetcherSubName(String keyword);

    List<String> salesFetcherQuantity(String p_name , String p_sub_name);
}
