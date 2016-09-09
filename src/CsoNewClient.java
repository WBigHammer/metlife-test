// default package

import java.math.BigDecimal;


/**
 * CsoNewClient entity. @author MyEclipse Persistence Tools
 */

public class CsoNewClient  implements java.io.Serializable {


    // Fields    

     private BigDecimal csoNewClientId;
     private Integer time;
     private String branch;
     private Integer newClient;
     private Integer availableCustomer;


    // Constructors

    /** default constructor */
    public CsoNewClient() {
    }

    
    /** full constructor */
    public CsoNewClient(Integer time, String branch, Integer newClient, Integer availableCustomer) {
        this.time = time;
        this.branch = branch;
        this.newClient = newClient;
        this.availableCustomer = availableCustomer;
    }

   
    // Property accessors

    public BigDecimal getCsoNewClientId() {
        return this.csoNewClientId;
    }
    
    public void setCsoNewClientId(BigDecimal csoNewClientId) {
        this.csoNewClientId = csoNewClientId;
    }

    public Integer getTime() {
        return this.time;
    }
    
    public void setTime(Integer time) {
        this.time = time;
    }

    public String getBranch() {
        return this.branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getNewClient() {
        return this.newClient;
    }
    
    public void setNewClient(Integer newClient) {
        this.newClient = newClient;
    }

    public Integer getAvailableCustomer() {
        return this.availableCustomer;
    }
    
    public void setAvailableCustomer(Integer availableCustomer) {
        this.availableCustomer = availableCustomer;
    }
   








}