package com.unichain.pay.dao;

import com.unichain.pay.entity.ChannelBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelBankMapper extends JpaRepository<ChannelBank, Long>, JpaSpecificationExecutor<ChannelBank>/*, BaseMapper<CompanyApp>*/ {

}
