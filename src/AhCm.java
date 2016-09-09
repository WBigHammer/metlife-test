// default package

import java.math.BigDecimal;


/**
 * AhCm entity. @author MyEclipse Persistence Tools
 */

public class AhCm  implements java.io.Serializable {


    // Fields    

     private BigDecimal ahCmId;
     private Integer time;
     private String channel;
     private String product;
     private double totalAnp;
     private double totalPy;
     private double totalPlan;
     private double totalAllAnp;
     private double refundableAnp;
     private double refundablePy;
     private double refundablePlan;
     private double refundableAllAnp;
     private double excludeRefundableAnp;
     private double excludeRefundablePy;
     private double excludeRefundablePlan;
     private double excludeRefundableAllAnp;
     private double persistencyRatio;
     private double lapseRatio;


    // Constructors

    /** default constructor */
    public AhCm() {
    }

    
    /** full constructor */
    public AhCm(Integer time, String channel, String product, double totalAnp, double totalPy, double totalPlan, double totalAllAnp, double refundableAnp, double refundablePy, double refundablePlan, double refundableAllAnp, double excludeRefundableAnp, double excludeRefundablePy, double excludeRefundablePlan, double excludeRefundableAllAnp, double persistencyRatio, double lapseRatio) {
        this.time = time;
        this.channel = channel;
        this.product = product;
        this.totalAnp = totalAnp;
        this.totalPy = totalPy;
        this.totalPlan = totalPlan;
        this.totalAllAnp = totalAllAnp;
        this.refundableAnp = refundableAnp;
        this.refundablePy = refundablePy;
        this.refundablePlan = refundablePlan;
        this.refundableAllAnp = refundableAllAnp;
        this.excludeRefundableAnp = excludeRefundableAnp;
        this.excludeRefundablePy = excludeRefundablePy;
        this.excludeRefundablePlan = excludeRefundablePlan;
        this.excludeRefundableAllAnp = excludeRefundableAllAnp;
        this.persistencyRatio = persistencyRatio;
        this.lapseRatio = lapseRatio;
    }

   
    // Property accessors

    public BigDecimal getAhCmId() {
        return this.ahCmId;
    }
    
    public void setAhCmId(BigDecimal ahCmId) {
        this.ahCmId = ahCmId;
    }

    public Integer getTime() {
        return this.time;
    }
    
    public void setTime(Integer time) {
        this.time = time;
    }

    public String getChannel() {
        return this.channel;
    }
    
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getProduct() {
        return this.product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }

    public double getTotalAnp() {
        return this.totalAnp;
    }
    
    public void setTotalAnp(double totalAnp) {
        this.totalAnp = totalAnp;
    }

    public double getTotalPy() {
        return this.totalPy;
    }
    
    public void setTotalPy(double totalPy) {
        this.totalPy = totalPy;
    }

    public double getTotalPlan() {
        return this.totalPlan;
    }
    
    public void setTotalPlan(double totalPlan) {
        this.totalPlan = totalPlan;
    }

    public double getTotalAllAnp() {
        return this.totalAllAnp;
    }
    
    public void setTotalAllAnp(double totalAllAnp) {
        this.totalAllAnp = totalAllAnp;
    }

    public double getRefundableAnp() {
        return this.refundableAnp;
    }
    
    public void setRefundableAnp(double refundableAnp) {
        this.refundableAnp = refundableAnp;
    }

    public double getRefundablePy() {
        return this.refundablePy;
    }
    
    public void setRefundablePy(double refundablePy) {
        this.refundablePy = refundablePy;
    }

    public double getRefundablePlan() {
        return this.refundablePlan;
    }
    
    public void setRefundablePlan(double refundablePlan) {
        this.refundablePlan = refundablePlan;
    }

    public double getRefundableAllAnp() {
        return this.refundableAllAnp;
    }
    
    public void setRefundableAllAnp(double refundableAllAnp) {
        this.refundableAllAnp = refundableAllAnp;
    }

    public double getExcludeRefundableAnp() {
        return this.excludeRefundableAnp;
    }
    
    public void setExcludeRefundableAnp(double excludeRefundableAnp) {
        this.excludeRefundableAnp = excludeRefundableAnp;
    }

    public double getExcludeRefundablePy() {
        return this.excludeRefundablePy;
    }
    
    public void setExcludeRefundablePy(double excludeRefundablePy) {
        this.excludeRefundablePy = excludeRefundablePy;
    }

    public double getExcludeRefundablePlan() {
        return this.excludeRefundablePlan;
    }
    
    public void setExcludeRefundablePlan(double excludeRefundablePlan) {
        this.excludeRefundablePlan = excludeRefundablePlan;
    }

    public double getExcludeRefundableAllAnp() {
        return this.excludeRefundableAllAnp;
    }
    
    public void setExcludeRefundableAllAnp(double excludeRefundableAllAnp) {
        this.excludeRefundableAllAnp = excludeRefundableAllAnp;
    }

    public double getPersistencyRatio() {
        return this.persistencyRatio;
    }
    
    public void setPersistencyRatio(double persistencyRatio) {
        this.persistencyRatio = persistencyRatio;
    }

    public double getLapseRatio() {
        return this.lapseRatio;
    }
    
    public void setLapseRatio(double lapseRatio) {
        this.lapseRatio = lapseRatio;
    }
   








}