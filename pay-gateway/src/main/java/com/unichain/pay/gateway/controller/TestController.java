//package com.unichain.pay.gateway.controller;
//
//import com.unichain.pay.biz.model.Address;
//import com.unichain.pay.biz.model.fact.AddressCheckResult;
//import com.unichain.pay.biz.test.Refuse;
//import com.unichain.pay.biz.utils.KieUtils;
//import com.unichain.pay.gateway.component.ReloadDroolsRules;
//import org.kie.core.runtime.KieSession;
//import org.kie.core.runtime.rule.QueryResults;
//import org.kie.core.runtime.rule.QueryResultsRow;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//
///**
// */
//@RequestMapping("/test")
//@Controller
//public class TestController {
//
//    @Resource
//    private ReloadDroolsRules rules;
//
//    @ResponseBody
//    @RequestMapping("/address")
//    public void test(){
//        KieSession kieSession = KieUtils.getKieContainer().newKieSession();
//
//        Address address = new Address();
//        address.setPostcode("994251");
//
//        AddressCheckResult result = new AddressCheckResult();
//        kieSession.insert(address);
//        kieSession.insert(result);
//        int ruleFiredCount = kieSession.fireAllRules();
//        System.out.println("触发了" + ruleFiredCount + "条规则");
//
//        if(result.isPostCodeResult()){
//            System.out.println("规则校验通过");
//        }
//
//        kieSession.dispose();
//    }
//
//    @ResponseBody
//    @RequestMapping("/re")
//    public void test11(){
//        KieSession ksession = KieUtils.getKieContainer().newKieSession();
////        KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
//
//        Refuse refuse1 = new Refuse();
//        Refuse refuse = new Refuse();
//        refuse.setName("godme");
//        refuse1.setName("judas");
//        ksession.insert(refuse);
//        ksession.insert(refuse1);
//        ksession.fireAllRules();
//        QueryResults find_person_result = ksession.getQueryResults("find_Person", "judas");
//        for(QueryResultsRow row : find_person_result){
//            Refuse p = (Refuse)row.get("$person");
//            System.out.println("find_person_result : " + p.getName());
//        }
//
//
//       /* Map<String,String> refuseDate = new HashMap<>();
//        Refuse refuse=new Refuse();
//        refuse.setAge(34);
//        kSession.setGlobal("refuseDate",refuseDate);
//        kSession.insert(refuse);
//        int count=kSession.fireAllRules();
//        System.out.println("规则执行条数：--------"+count);
//        System.out.println("规则执行完成--------"+refuse.toString());
//        System.out.println(kSession.getGlobals().toString());*/
//    }
//
//    @ResponseBody
//    @RequestMapping("/reload")
//    public String reload() throws IOException {
//        rules.reload();
//        return "ok";
//    }
//}
