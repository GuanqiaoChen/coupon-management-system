package com.imooc.passbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>Merchant entity</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {

    /** Merchant ID. Primary Key */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    /** Merchant name. Global unique */
    @Basic
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /** Merchant logo */
    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /** Business lisence url */
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;

    /** Contact phone */
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;

    /** Address */
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    /** Whether is audit */
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit = false;
}
