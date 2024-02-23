package com.ms_perfume.ms_perfume.serviceImp;

import com.ms_perfume.ms_perfume.entity.Sales;
import com.ms_perfume.ms_perfume.entity.StockBox;
import com.ms_perfume.ms_perfume.repo.SalesRepository;
import com.ms_perfume.ms_perfume.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Sales> addSales(List<Sales> sales) {
        for (Sales s : sales) {
            String sql = "select * from ms_master.stock_box where p_name=? and p_sub_name=?";
            List<StockBox> resultList = jdbcTemplate.query(sql, new Object[]{s.getpName(), s.getpSubName()}, new BeanPropertyRowMapper<>(StockBox.class));
            for (StockBox stockBox : resultList) {
                String tempId = String.valueOf(stockBox.getId());
                String currentQuantity = String.valueOf(stockBox.getQuantity());
                int balanceQuantity = Integer.parseInt(currentQuantity) - Integer.parseInt(s.getQuantity());
                System.out.println(balanceQuantity);
                String updateSql = "UPDATE ms_master.stock_box SET quantity = ? WHERE id= ?";
                int rowsAffected = jdbcTemplate.update(updateSql, balanceQuantity, tempId);
            }
        }
        return this.salesRepository.saveAll(sales);
    }
}

