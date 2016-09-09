// default package

import java.math.BigDecimal;


/**
 * QuickViewBPS3 entity. @author MyEclipse Persistence Tools
 */

public class QuickViewBPS3  implements java.io.Serializable {


    // Fields    

     private BigDecimal quickViewBps3Id;
     private Integer time;
     private String channel;
     private short rank;
     private double monthlyActual;
     private double monthlyProj;
     private double monthlyLy;
     private double monthlyPlan;
     private double monthlyActVsProj;
     private double monthlyActVsLy;
     private double monthlyActVsPlan;
     private double quarterlyQ1Act;
     private double quarterlyQ2Act;
     private double quarterlyQ3Act;
     private double quarterlyQ4Act;
     private double quarterlyLyAct;
     private double quarterlyPlan;
     private double quarterlyGap;
     private double quarterlyActVsLast;
     private double quarterlyActYoy;
     private double quarterlyActVsPlan;
     private double ytdAct;
     private double ytdPlan;
     private double ytdLy;
     private double ytdActVsPlan;
     private double ytdActVsLy;
     private double fullYearLy;
     private double fullYearAct;
     private double fullYearProj;
     private double fullYearPlan;
     private double fullYearProjVsLy;
     private double fullYearProjVsPlan;


    // Constructors

    /** default constructor */
    public QuickViewBPS3() {
    }

    
    /** full constructor */
    public QuickViewBPS3(Integer time, String channel, short rank, double monthlyActual, double monthlyProj, double monthlyLy, double monthlyPlan, double monthlyActVsProj, double monthlyActVsLy, double monthlyActVsPlan, double quarterlyQ1Act, double quarterlyQ2Act, double quarterlyQ3Act, double quarterlyQ4Act, double quarterlyLyAct, double quarterlyPlan, double quarterlyGap, double quarterlyActVsLast, double quarterlyActYoy, double quarterlyActVsPlan, double ytdAct, double ytdPlan, double ytdLy, double ytdActVsPlan, double ytdActVsLy, double fullYearLy, double fullYearAct, double fullYearProj, double fullYearPlan, double fullYearProjVsLy, double fullYearProjVsPlan) {
        this.time = time;
        this.channel = channel;
        this.rank = rank;
        this.monthlyActual = monthlyActual;
        this.monthlyProj = monthlyProj;
        this.monthlyLy = monthlyLy;
        this.monthlyPlan = monthlyPlan;
        this.monthlyActVsProj = monthlyActVsProj;
        this.monthlyActVsLy = monthlyActVsLy;
        this.monthlyActVsPlan = monthlyActVsPlan;
        this.quarterlyQ1Act = quarterlyQ1Act;
        this.quarterlyQ2Act = quarterlyQ2Act;
        this.quarterlyQ3Act = quarterlyQ3Act;
        this.quarterlyQ4Act = quarterlyQ4Act;
        this.quarterlyLyAct = quarterlyLyAct;
        this.quarterlyPlan = quarterlyPlan;
        this.quarterlyGap = quarterlyGap;
        this.quarterlyActVsLast = quarterlyActVsLast;
        this.quarterlyActYoy = quarterlyActYoy;
        this.quarterlyActVsPlan = quarterlyActVsPlan;
        this.ytdAct = ytdAct;
        this.ytdPlan = ytdPlan;
        this.ytdLy = ytdLy;
        this.ytdActVsPlan = ytdActVsPlan;
        this.ytdActVsLy = ytdActVsLy;
        this.fullYearLy = fullYearLy;
        this.fullYearAct = fullYearAct;
        this.fullYearProj = fullYearProj;
        this.fullYearPlan = fullYearPlan;
        this.fullYearProjVsLy = fullYearProjVsLy;
        this.fullYearProjVsPlan = fullYearProjVsPlan;
    }

   
    // Property accessors

    public BigDecimal getQuickViewBps3Id() {
        return this.quickViewBps3Id;
    }
    
    public void setQuickViewBps3Id(BigDecimal quickViewBps3Id) {
        this.quickViewBps3Id = quickViewBps3Id;
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

    public short getRank() {
        return this.rank;
    }
    
    public void setRank(short rank) {
        this.rank = rank;
    }

    public double getMonthlyActual() {
        return this.monthlyActual;
    }
    
    public void setMonthlyActual(double monthlyActual) {
        this.monthlyActual = monthlyActual;
    }

    public double getMonthlyProj() {
        return this.monthlyProj;
    }
    
    public void setMonthlyProj(double monthlyProj) {
        this.monthlyProj = monthlyProj;
    }

    public double getMonthlyLy() {
        return this.monthlyLy;
    }
    
    public void setMonthlyLy(double monthlyLy) {
        this.monthlyLy = monthlyLy;
    }

    public double getMonthlyPlan() {
        return this.monthlyPlan;
    }
    
    public void setMonthlyPlan(double monthlyPlan) {
        this.monthlyPlan = monthlyPlan;
    }

    public double getMonthlyActVsProj() {
        return this.monthlyActVsProj;
    }
    
    public void setMonthlyActVsProj(double monthlyActVsProj) {
        this.monthlyActVsProj = monthlyActVsProj;
    }

    public double getMonthlyActVsLy() {
        return this.monthlyActVsLy;
    }
    
    public void setMonthlyActVsLy(double monthlyActVsLy) {
        this.monthlyActVsLy = monthlyActVsLy;
    }

    public double getMonthlyActVsPlan() {
        return this.monthlyActVsPlan;
    }
    
    public void setMonthlyActVsPlan(double monthlyActVsPlan) {
        this.monthlyActVsPlan = monthlyActVsPlan;
    }

    public double getQuarterlyQ1Act() {
        return this.quarterlyQ1Act;
    }
    
    public void setQuarterlyQ1Act(double quarterlyQ1Act) {
        this.quarterlyQ1Act = quarterlyQ1Act;
    }

    public double getQuarterlyQ2Act() {
        return this.quarterlyQ2Act;
    }
    
    public void setQuarterlyQ2Act(double quarterlyQ2Act) {
        this.quarterlyQ2Act = quarterlyQ2Act;
    }

    public double getQuarterlyQ3Act() {
        return this.quarterlyQ3Act;
    }
    
    public void setQuarterlyQ3Act(double quarterlyQ3Act) {
        this.quarterlyQ3Act = quarterlyQ3Act;
    }

    public double getQuarterlyQ4Act() {
        return this.quarterlyQ4Act;
    }
    
    public void setQuarterlyQ4Act(double quarterlyQ4Act) {
        this.quarterlyQ4Act = quarterlyQ4Act;
    }

    public double getQuarterlyLyAct() {
        return this.quarterlyLyAct;
    }
    
    public void setQuarterlyLyAct(double quarterlyLyAct) {
        this.quarterlyLyAct = quarterlyLyAct;
    }

    public double getQuarterlyPlan() {
        return this.quarterlyPlan;
    }
    
    public void setQuarterlyPlan(double quarterlyPlan) {
        this.quarterlyPlan = quarterlyPlan;
    }

    public double getQuarterlyGap() {
        return this.quarterlyGap;
    }
    
    public void setQuarterlyGap(double quarterlyGap) {
        this.quarterlyGap = quarterlyGap;
    }

    public double getQuarterlyActVsLast() {
        return this.quarterlyActVsLast;
    }
    
    public void setQuarterlyActVsLast(double quarterlyActVsLast) {
        this.quarterlyActVsLast = quarterlyActVsLast;
    }

    public double getQuarterlyActYoy() {
        return this.quarterlyActYoy;
    }
    
    public void setQuarterlyActYoy(double quarterlyActYoy) {
        this.quarterlyActYoy = quarterlyActYoy;
    }

    public double getQuarterlyActVsPlan() {
        return this.quarterlyActVsPlan;
    }
    
    public void setQuarterlyActVsPlan(double quarterlyActVsPlan) {
        this.quarterlyActVsPlan = quarterlyActVsPlan;
    }

    public double getYtdAct() {
        return this.ytdAct;
    }
    
    public void setYtdAct(double ytdAct) {
        this.ytdAct = ytdAct;
    }

    public double getYtdPlan() {
        return this.ytdPlan;
    }
    
    public void setYtdPlan(double ytdPlan) {
        this.ytdPlan = ytdPlan;
    }

    public double getYtdLy() {
        return this.ytdLy;
    }
    
    public void setYtdLy(double ytdLy) {
        this.ytdLy = ytdLy;
    }

    public double getYtdActVsPlan() {
        return this.ytdActVsPlan;
    }
    
    public void setYtdActVsPlan(double ytdActVsPlan) {
        this.ytdActVsPlan = ytdActVsPlan;
    }

    public double getYtdActVsLy() {
        return this.ytdActVsLy;
    }
    
    public void setYtdActVsLy(double ytdActVsLy) {
        this.ytdActVsLy = ytdActVsLy;
    }

    public double getFullYearLy() {
        return this.fullYearLy;
    }
    
    public void setFullYearLy(double fullYearLy) {
        this.fullYearLy = fullYearLy;
    }

    public double getFullYearAct() {
        return this.fullYearAct;
    }
    
    public void setFullYearAct(double fullYearAct) {
        this.fullYearAct = fullYearAct;
    }

    public double getFullYearProj() {
        return this.fullYearProj;
    }
    
    public void setFullYearProj(double fullYearProj) {
        this.fullYearProj = fullYearProj;
    }

    public double getFullYearPlan() {
        return this.fullYearPlan;
    }
    
    public void setFullYearPlan(double fullYearPlan) {
        this.fullYearPlan = fullYearPlan;
    }

    public double getFullYearProjVsLy() {
        return this.fullYearProjVsLy;
    }
    
    public void setFullYearProjVsLy(double fullYearProjVsLy) {
        this.fullYearProjVsLy = fullYearProjVsLy;
    }

    public double getFullYearProjVsPlan() {
        return this.fullYearProjVsPlan;
    }
    
    public void setFullYearProjVsPlan(double fullYearProjVsPlan) {
        this.fullYearProjVsPlan = fullYearProjVsPlan;
    }

}