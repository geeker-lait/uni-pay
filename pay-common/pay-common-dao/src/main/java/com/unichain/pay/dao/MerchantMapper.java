package com.unichain.pay.dao;

import com.unichain.pay.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantMapper extends JpaRepository<Merchant, Long>, JpaSpecificationExecutor<Merchant>/*, BaseMapper<CompanyApp>*/ {

}
