package com.ms_perfume.ms_perfume.serviceImp;
import com.ms_perfume.ms_perfume.dto.LoginResponse;
import com.ms_perfume.ms_perfume.entity.StockBox;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ms_perfume.ms_perfume.entity.Purchase;
import com.ms_perfume.ms_perfume.repo.PurchaseRepository;
import com.ms_perfume.ms_perfume.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Purchase> addPurchase(List<Purchase> purchase) {

        for (Purchase p : purchase) {
            String sql = "select * from ms_master.stock_box where p_name=? and p_sub_name=?";
            List<StockBox> resultList = jdbcTemplate.query(sql, new Object[]{p.getpName(), p.getpSubName()}, new BeanPropertyRowMapper<>(StockBox.class));
            if(!resultList.isEmpty()){
                for (StockBox stockBox : resultList) {
                    String tempId = String.valueOf(stockBox.getId());
                    String currentQuantity = String.valueOf(stockBox.getQuantity());
                    int addQuantity=Integer.parseInt(p.getQuantity())+Integer.parseInt(currentQuantity);
                    System.out.println(addQuantity);
                    String updateSql = "UPDATE ms_master.stock_box SET quantity = ? WHERE id= ?";
                    int rowsAffected = jdbcTemplate.update(updateSql,addQuantity, tempId);
                    System.out.println(rowsAffected);
                }
            }
            else {
                String insertSql = "INSERT INTO ms_master.stock_box (`p_name`, `p_sub_name`, `quantity`) VALUES (?, ?, ?); ";
                int rowsAffected = jdbcTemplate.update(insertSql,p.getpName(),p.getpSubName(),p.getQuantity());
                System.out.println(rowsAffected);


            }
        }
        return purchaseRepository.saveAll(purchase);
    }

    @Override
    public List<String> salesFetcher() {
        String sql = "select p_name from ms_master.stock_box  group by p_name order by p_name";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<String> salesFetcherSubName(String keyword) {
        String sql = "SELECT p_sub_name FROM ms_master.stock_box where p_name=? " +
                " group by p_sub_name,p_name order by p_sub_name; ";
        String param = keyword;
        return jdbcTemplate.queryForList(sql, String.class,param);
    }

    @Override
    public List<String> salesFetcherQuantity(String p_name, String p_sub_name) {
        String sql = "SELECT quantity FROM ms_master.stock_box where p_name=? and p_sub_name = ? " ;
        return jdbcTemplate.queryForList(sql, String.class,p_name,p_sub_name);
    }


}
