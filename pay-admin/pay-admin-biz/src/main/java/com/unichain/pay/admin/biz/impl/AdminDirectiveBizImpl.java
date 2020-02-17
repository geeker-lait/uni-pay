//package com.unichain.pay.admin.biz.impl;
//
//import com.unichain.pay.admin.biz.AdminDirectiveBiz;
//import com.unichain.pay.entity.Channel;
//import com.unichain.pay.entity.Directive;
//import com.unichain.pay.pojo.dto.admin.BindChannelAndDirectiveDto;
//import com.unichain.pay.service.ChannelService;
//import com.unichain.pay.service.DirectiveService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminDirectiveBizImpl implements AdminDirectiveBiz {
//
//    // 日志
//    private static final Logger logger = LoggerFactory.getLogger(AdminDirectiveBizImpl.class);
//
//
//    @Autowired
//    private DirectiveService directiveService;
//
//    @Autowired
//    private ChannelService channelService;
//
//    @Override
//    public Integer bindChannelAndDirective(BindChannelAndDirectiveDto bindChannelAndDirectiveDto) {
//        // 判断是否存在
////        Directive queryDirBean = new Directive();
////        queryDirBean.setId(bindChannelAndDirectiveDto.getDirectiveId());
////        Directive dirBean = directiveService.findOne(queryDirBean);
////        if (dirBean == null) {
////            throw new BusinessException("该条指令不存在");
////        }
////
////        Channel queryChannelBean = new Channel();
////        queryChannelBean.setId(bindChannelAndDirectiveDto.getChannelId());
////        Channel channelBean = channelService.findOne(queryChannelBean);
////        if (channelBean == null) {
////            throw new BusinessException("该条通道不存在");
////        }
////
////        if (StringUtils.isNotBlank(dirBean.getChannelCode())) {
////            throw new BusinessException("该条指令已绑定通道");
////        }
////
////        dirBean.setChannelCode(channelBean.getChannelCode());
////        try {
////            directiveService.saveAndFlush(dirBean);
////        } catch (Exception e) {
////            logger.info("指令绑定支付通道出现错误  >>> {}", e);
////            return 0;
////        }
//        return 1;
//    }
//}
