package com.unichain.pay.dao;

import com.unichain.pay.entity.Directive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 指令 Mapper 接口
 * </p>
 *
 * @since 2019-07-09
 */
@Repository
public interface PayDirectiveMapper extends JpaRepository<Directive, Long>, JpaSpecificationExecutor<Directive>/*,BaseMapper<Directive>*/ {
}
