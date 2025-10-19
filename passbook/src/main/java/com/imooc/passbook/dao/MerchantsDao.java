package com.imooc.passbook.dao;

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>Merchants Dao interface</h1>
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * <h2>Find merchant by ID</h2>
     * @param id Merchant ID
     * @return {@link Merchants}
     * */
    Merchants findById(Integer id);

    /**
     * <h2>Find merchant by name</h2>
     * @param name Merchant name
     * @return {@link Merchants}
     * */
    Merchants findByName(String name);

    /**
     * <h2>Find multiple merchants by ID</h2>
     * @param ids Merchant IDs
     * @return {@link Merchants}
     * */
    List<Merchants> findByIdIn(List<Integer> ids);
}
