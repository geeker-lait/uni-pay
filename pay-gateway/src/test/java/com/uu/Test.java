//package com.uu;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.extension.service.IService;
//import com.unichain.pay.core.PayParam;
//import com.unichain.pay.core.model.IPaySave;
//import com.unichain.pay.core.model.PayBindCardDto;
//
//import com.unichain.pay.biz.chain.CatalogLoader;
//import com.unichain.pay.biz.utils.BizBeanUtils;
//import com.unichain.pay.biz.utils.Utils;
//import com.unichain.pay.gateway.PayApplication;
//
//import org.apache.commons.chain.Catalog;
//import org.apache.commons.chain.Command;
//import org.junit.runner.RunWith;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.apache.commons.lang3.StringUtils.upperCase;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PayApplication.class)
////@TestPropertySource("classpath:application.yml")
//public class Test {
//    @Autowired
//    private PayParamsScanner payParamsScanner;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private BizBeanUtils bizBeanUtils;
//    @org.junit.Test
//    public void test() throws IllegalAccessException, InstantiationException {
//        Class<? extends AbstractPayParams> paramClass = payParamsScanner.getParamsMap().get("aliPayParams");
//        PayParam payParams = paramClass.newInstance();
//
//        payParams.setParams("123","haha");
//        System.out.println(JSON.toJSONString(payParams));
//        System.out.println(payParams.getClass().getName());
//
////        return payParams;
//    }
//
//    @org.junit.Test
//    public void testPayParam(){
//        Map map = new HashMap();
//        map.put("channel_code","aliPay");
//
//        String tableName = "pay_channel";
//        String column = "contacter";
//
////        System.out.println(bizBeanUtils.getTabelValue(tableName,column,map));
//    }
//
//    @Autowired
//    private CatalogLoader catalogLoader;
//
//    @org.junit.Test
//    public void testPayChain() throws Exception {
//        Catalog catalog = catalogLoader.getCatalog();
//        Command command = catalog.getCommand("payChain");
//        PayChainContext context = new PayChainContext();
//        command.execute(context);
//    }
//
//    @org.junit.Test
//    public void testPayUserInfo(){
//        PayBindCardDto dto = new PayBindCardDto();
//        dto.setAppCode("appCode");
//        dto.setChannelCode("channelCode");
//        dto.setUserId("userId");
//        dto.setData("data");
//
//        DefaultPayResponse payResponse = new DefaultPayResponse();
//
//        payResponse.setPaySave(dto);
//
//
//        IPaySave paySave = payResponse.getPaySave();
//        try {
//            Class c = Class.forName(paySave.getEntityPackageName()+"."+paySave.getEntityClassName());
//            Object obj = c.newInstance();
//            IService service = applicationContext.getBean(Utils.smallCase(paySave.getEntityClassName())+"ServiceImpl",IService.class);
//            BeanUtils.copyProperties(paySave,obj);
//            service.save(obj);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
