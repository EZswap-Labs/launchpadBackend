/**
 * Copyright 2023 bejson.com
 */
package com.ezswap.entry.wert;

/**
 * Auto-generated: 2023-04-11 14:31:46
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Order {

    private String base;
    private String base_amount;
    private String quote;
    private String quote_amount;
    private String address;
    private String transaction_id;
    private Partner_data partner_data;

    public void setBase(String base) {
        this.base = base;
    }

    public String getBase() {
        return base;
    }

    public void setBase_amount(String base_amount) {
        this.base_amount = base_amount;
    }

    public String getBase_amount() {
        return base_amount;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote_amount(String quote_amount) {
        this.quote_amount = quote_amount;
    }

    public String getQuote_amount() {
        return quote_amount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setPartner_data(Partner_data partner_data) {
        this.partner_data = partner_data;
    }

    public Partner_data getPartner_data() {
        return partner_data;
    }

}