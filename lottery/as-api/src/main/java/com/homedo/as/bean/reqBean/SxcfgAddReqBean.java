package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by quyang on 2018/4/25.
 */
public class SxcfgAddReqBean {
    /*
   <option value="馬">馬</option>
   <option value="龍">龍</option>
   <option value="羊">羊</option>
   <option value="狗">狗</option>
   <option value="豬">豬</option>
   <option value="雞">雞</option>
   <option value="兔">兔</option>
   <option value="牛">牛</option>
   <option value="蛇">蛇</option>
   <option value="猴">猴</option>
   <option value="鼠">鼠</option>
   <option value="虎">虎</option>*/

    @NotNull(message = "请填写年份")
    private Integer year;


    @NotBlank(message = "请填写生肖")
    private String sxMa;
    @NotBlank(message = "请填写号码")
    private String numMa;

    @NotBlank(message = "请填写生肖")
    private String sxLong;
    @NotBlank(message = "请填写号码")
    private String numLong;

    @NotBlank(message = "请填写生肖")
    private String sxYang;
    @NotBlank(message = "请填写号码")
    private String numYang;

    @NotBlank(message = "请填写生肖")
    private String sxGou;
    @NotBlank(message = "请填写号码")
    private String numGou;

    @NotBlank(message = "请填写生肖")
    private String sxZhu;
    @NotBlank(message = "请填写号码")
    private String numZhu;

    @NotBlank(message = "请填写生肖")
    private String sxGi;
    @NotBlank(message = "请填写号码")
    private String numGi;

    @NotBlank(message = "请填写生肖")
    private String sxTu;
    @NotBlank(message = "请填写号码")
    private String numTu;

    @NotBlank(message = "请填写生肖")
    private String sxNiu;
    @NotBlank(message = "请填写号码")
    private String numNiu;

    @NotBlank(message = "请填写生肖")
    private String sxShe;
    @NotBlank(message = "请填写号码")
    private String numShe;

    @NotBlank(message = "请填写生肖")
    private String sxHou;
    @NotBlank(message = "请填写号码")
    private String numHou;

    @NotBlank(message = "请填写生肖")
    private String sxShu;
    @NotBlank(message = "请填写号码")
    private String numShu;

    @NotBlank(message = "请填写生肖")
    private String sxHu;
    @NotBlank(message = "请填写号码")
    private String numHu;


    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSxMa() {
        return sxMa;
    }

    public void setSxMa(String sxMa) {
        this.sxMa = sxMa;
    }

    public String getNumMa() {
        return numMa;
    }

    public void setNumMa(String numMa) {
        this.numMa = numMa;
    }

    public String getSxLong() {
        return sxLong;
    }

    public void setSxLong(String sxLong) {
        this.sxLong = sxLong;
    }

    public String getNumLong() {
        return numLong;
    }

    public void setNumLong(String numLong) {
        this.numLong = numLong;
    }

    public String getSxYang() {
        return sxYang;
    }

    public void setSxYang(String sxYang) {
        this.sxYang = sxYang;
    }

    public String getNumYang() {
        return numYang;
    }

    public void setNumYang(String numYang) {
        this.numYang = numYang;
    }

    public String getSxGou() {
        return sxGou;
    }

    public void setSxGou(String sxGou) {
        this.sxGou = sxGou;
    }

    public String getNumGou() {
        return numGou;
    }

    public void setNumGou(String numGou) {
        this.numGou = numGou;
    }

    public String getSxZhu() {
        return sxZhu;
    }

    public void setSxZhu(String sxZhu) {
        this.sxZhu = sxZhu;
    }

    public String getNumZhu() {
        return numZhu;
    }

    public void setNumZhu(String numZhu) {
        this.numZhu = numZhu;
    }

    public String getSxGi() {
        return sxGi;
    }

    public void setSxGi(String sxGi) {
        this.sxGi = sxGi;
    }

    public String getNumGi() {
        return numGi;
    }

    public void setNumGi(String numGi) {
        this.numGi = numGi;
    }

    public String getSxTu() {
        return sxTu;
    }

    public void setSxTu(String sxTu) {
        this.sxTu = sxTu;
    }

    public String getNumTu() {
        return numTu;
    }

    public void setNumTu(String numTu) {
        this.numTu = numTu;
    }

    public String getSxNiu() {
        return sxNiu;
    }

    public void setSxNiu(String sxNiu) {
        this.sxNiu = sxNiu;
    }

    public String getNumNiu() {
        return numNiu;
    }

    public void setNumNiu(String numNiu) {
        this.numNiu = numNiu;
    }

    public String getSxShe() {
        return sxShe;
    }

    public void setSxShe(String sxShe) {
        this.sxShe = sxShe;
    }

    public String getNumShe() {
        return numShe;
    }

    public void setNumShe(String numShe) {
        this.numShe = numShe;
    }

    public String getSxHou() {
        return sxHou;
    }

    public void setSxHou(String sxHou) {
        this.sxHou = sxHou;
    }

    public String getNumHou() {
        return numHou;
    }

    public void setNumHou(String numHou) {
        this.numHou = numHou;
    }

    public String getSxShu() {
        return sxShu;
    }

    public void setSxShu(String sxShu) {
        this.sxShu = sxShu;
    }

    public String getNumShu() {
        return numShu;
    }

    public void setNumShu(String numShu) {
        this.numShu = numShu;
    }

    public String getSxHu() {
        return sxHu;
    }

    public void setSxHu(String sxHu) {
        this.sxHu = sxHu;
    }

    public String getNumHu() {
        return numHu;
    }

    public void setNumHu(String numHu) {
        this.numHu = numHu;
    }
}
