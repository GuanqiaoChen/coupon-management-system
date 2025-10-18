package com.imooc.passbook.dao;

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>Merchants Dao interface</h1>
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * <h2>Find merchant object according to ID</h2>
     * @param id Merchant ID
     * @return {@link Merchants}
     * */
    Merchants findById(Integer id);

    /**
     * <h2>Find merchant object according to name</h2>
     * @param name Merchant name
     * @return {@link Merchants}
     * */
    Merchants findByName(String name);
}
