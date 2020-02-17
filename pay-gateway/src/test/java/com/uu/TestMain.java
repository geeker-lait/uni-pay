//package com.uu;
//
//import com.unichain.pay.gateway.test.BestFinder;
//
//public class TestMain {
//    @org.junit.Test
//    public void findPrices(){
//        BestFinder bestFinder = new BestFinder();
//        long st = System.currentTimeMillis();
//        System.out.println(bestFinder.findPrices("iPhonX"));
//        System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
//    }
//    @org.junit.Test
//    public void findPricesParallel(){
//        BestFinder bestFinder = new BestFinder();
//        long st = System.currentTimeMillis();
//        System.out.println(bestFinder.findPricesParallel("iPhonX"));
//        System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
//    }
//    @org.junit.Test
//    public void findPricesAsync(){
//        BestFinder bestFinder = new BestFinder();
//        long st = System.currentTimeMillis();
//        System.out.println(bestFinder.findPricesAsync("iPhonX"));
//        System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
//    }
//}
