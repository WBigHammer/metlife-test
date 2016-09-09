// default package

import java.math.BigDecimal;


/**
 * BxsForeignCapital entity. @author MyEclipse Persistence Tools
 */

public class BxsForeignCapital  implements java.io.Serializable {


    // Fields    

     private BigDecimal ABxsForgignCapitalId;
     private String bank;
     private String branch;
     private double anp;
     private double nextMonthAnpTarget;
     private double nextMonthAnp;
     private double ytdAnpTarget;
     private double ytdAnp;
     private double fullYearAnpTarget;
     private double fullYearAnp;
     private Integer time;


    // Constructors

    /** default constructor */
    public BxsForeignCapital() {
    }

    
    /** full constructor */
    public BxsForeignCapital(String bank, String branch, double anp, double nextMonthAnpTarget, double nextMonthAnp, double ytdAnpTarget, double ytdAnp, double fullYearAnpTarget, double fullYearAnp, Integer time) {
        this.bank = bank;
        this.branch = branch;
        this.anp = anp;
        this.nextMonthAnpTarget = nextMonthAnpTarget;
        this.nextMonthAnp = nextMonthAnp;
        this.ytdAnpTarget = ytdAnpTarget;
        this.ytdAnp = ytdAnp;
        this.fullYearAnpTarget = fullYearAnpTarget;
        this.fullYearAnp = fullYearAnp;
        this.time = time;
    }

   
    // Property accessors

    public BigDecimal getABxsForgignCapitalId() {
        return this.ABxsForgignCapitalId;
    }
    
    public void setABxsForgignCapitalId(BigDecimal ABxsForgignCapitalId) {
        this.ABxsForgignCapitalId = ABxsForgignCapitalId;
    }

    public String getBank() {
        return this.bank;
    }
    
    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return this.branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getAnp() {
        return this.anp;
    }
    
    public void setAnp(double anp) {
        this.anp = anp;
    }

    public double getNextMonthAnpTarget() {
        return this.nextMonthAnpTarget;
    }
    
    public void setNextMonthAnpTarget(double nextMonthAnpTarget) {
        this.nextMonthAnpTarget = nextMonthAnpTarget;
    }

    public double getNextMonthAnp() {
        return this.nextMonthAnp;
    }
    
    public void setNextMonthAnp(double nextMonthAnp) {
        this.nextMonthAnp = nextMonthAnp;
    }

    public double getYtdAnpTarget() {
        return this.ytdAnpTarget;
    }
    
    public void setYtdAnpTarget(double ytdAnpTarget) {
        this.ytdAnpTarget = ytdAnpTarget;
    }

    public double getYtdAnp() {
        return this.ytdAnp;
    }
    
    public void setYtdAnp(double ytdAnp) {
        this.ytdAnp = ytdAnp;
    }

    public double getFullYearAnpTarget() {
        return this.fullYearAnpTarget;
    }
    
    public void setFullYearAnpTarget(double fullYearAnpTarget) {
        this.fullYearAnpTarget = fullYearAnpTarget;
    }

    public double getFullYearAnp() {
        return this.fullYearAnp;
    }
    
    public void setFullYearAnp(double fullYearAnp) {
        this.fullYearAnp = fullYearAnp;
    }

    public Integer getTime() {
        return this.time;
    }
    
    public void setTime(Integer time) {
        this.time = time;
    }
   








}