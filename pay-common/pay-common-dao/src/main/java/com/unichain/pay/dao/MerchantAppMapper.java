package com.unichain.pay.dao;

import com.unichain.pay.entity.MerchantApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantAppMapper extends JpaRepository<MerchantApp, Long>, JpaSpecificationExecutor<MerchantApp>/*, BaseMapper<CompanyApp>*/ {

}
