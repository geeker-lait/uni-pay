package com.unichain.pay.core;


public interface PayRequestHandler {

    PayRequestHandler sign(String prikeyvalue/*,PayParam payParam*/);

    PayRequestHandler encrypt(String oid_partner, String YT_RSA_PUBLIC/*,PayParam payParam*/);

    String toJsonParam();

    default void buildPayParam() {

    }
}
