package com.unichain.pay.service;

import com.unichain.framework.common.CrudService;
import com.unichain.pay.dao.DirectiveMapper;
import com.unichain.pay.entity.Directive;


/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/2/2019
 * @Description ${Description}
 */
public interface DirectiveService extends CrudService<Directive, DirectiveMapper> {

    Directive getDirectiveByChannelIdAndChannelName(Long channelId, String directiveName);
}
