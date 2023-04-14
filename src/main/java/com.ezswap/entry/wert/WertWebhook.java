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
public class WertWebhook {

    private String type;
    private String click_id;
    private Order order;
    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setClick_id(String click_id) {
         this.click_id = click_id;
     }
     public String getClick_id() {
         return click_id;
     }

    public void setOrder(Order order) {
         this.order = order;
     }
     public Order getOrder() {
         return order;
     }

}