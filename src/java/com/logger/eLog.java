/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

/**
 *
 * @author Debo
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="error_log")
public class eLog {
    String service_source;
    String channel;
    String transaction_type;
    String provider_name;
    String pido_account;
    String beneficiary_id;
    String error_description;
    String error_date;
    
   public String getService(){
      return service_source;
   }

   @XmlElement(name="service_source")
   public void setService(String service_source){
      this.service_source = service_source;
   }

   public String getChannel(){
      return channel;
   }

   @XmlElement (name="channel")
   public void setChannel(String channel){
      this.channel = channel;
   }

   public String getType(){
      return transaction_type;
   }

   @XmlElement (name="transaction_type")
   public void setType(String transaction_type){
      this.transaction_type = transaction_type;
   }
   
   public String getProvider(){
      return provider_name;
   }

   @XmlElement (name="provider_name")
   public void setProvider(String provider_name){
      this.provider_name = provider_name;
   }
   
   public String getPido(){
      return pido_account;
   }

   @XmlElement (name="pido_account")
   public void setPido(String pido_account){
      this.pido_account = pido_account;
   }
   
   public String getBenId(){
      return beneficiary_id;
   }

   @XmlElement (name="beneficiary_id")
   public void setBenId(String beneficiary_id){
      this.beneficiary_id = beneficiary_id;
   }
   
    public String getDescription(){
      return error_description;
   }

   @XmlElement (name="error_description")
   public void setDescription(String error_description){
      this.error_description = error_description;
   }
   
   public String getErrorDate(){
      return error_date;
   }

   @XmlElement (name="error_date")
   public void setErrorDate(String error_date){
      this.error_date = error_date;
   }
   @Override
   public String toString() {
      return "Service Source [" + this.service_source + "], Channel [" + this.channel + "], Transaction Type [" + this.transaction_type + "],Provider Name [" + this.provider_name + "],Pido Account [" + this.pido_account + "], Beneficiary [" + this.beneficiary_id + "], Description [" + this.error_description + "],  Error Date[" + this.error_date + "]";
   }
}
