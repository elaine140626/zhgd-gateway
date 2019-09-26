package com.hujiang.project.zhgd.hjProjectWorkers.domain;

public class ProjectWorkersParam {




    /** ID */
    private Integer id;
    /** 姓名 */
    private String empName;
    /** 身份证号码 */
    private String idCode;
    /** 手机号码 */
    private Integer empPhon;
    /** 性别 */
    private String empSex;
    /** 民族 */
    private String empNation;
    /** 身份证地址 */
    private String idAddress;
    /** 签发机关 */
    private String idAgency;
    /** 有效期限 */
    private String idValiddate;
    /** 籍贯 */
    private String nativePlace;
    /** 开户行 */
    private String empBankname;
    /** 银行账号 */
    private String empCardnum;
    /** 简易劳动合同上传状态（0、否。1、是） */
    private Integer contract;
    /** 工人进场承诺书上传状态（0、否。1、是） */
    private Integer entrance;
    /** 工人退场承诺书上传状态（0、否。1、是） */
    private Integer exeunt;
    /** 两制“工作”确认书上传状态（0、否。1、是） */
    private Integer workConfirm;
    /** 身份证正反面文件上传状态（0、否。1、是） */
    private Integer iDCardPDF;
    /** 安全教育培训是否合格（0、否。1、是） */
    private Integer isTrain;
    /** 人脸照片 */
    private String faceUrl;
    /** 身份证正面照片 */
    private String idphotoScan;
    /** 身份证反面照片 */
    private String idphotoScan2;
    /** 银行卡照片 */
    private String bankCardUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Integer getEmpPhon() {
        return empPhon;
    }

    public void setEmpPhon(Integer empPhon) {
        this.empPhon = empPhon;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpNation() {
        return empNation;
    }

    public void setEmpNation(String empNation) {
        this.empNation = empNation;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(String idAgency) {
        this.idAgency = idAgency;
    }

    public String getIdValiddate() {
        return idValiddate;
    }

    public void setIdValiddate(String idValiddate) {
        this.idValiddate = idValiddate;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEmpBankname() {
        return empBankname;
    }

    public void setEmpBankname(String empBankname) {
        this.empBankname = empBankname;
    }

    public String getEmpCardnum() {
        return empCardnum;
    }

    public void setEmpCardnum(String empCardnum) {
        this.empCardnum = empCardnum;
    }

    public Integer getContract() {
        return contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
    }

    public Integer getEntrance() {
        return entrance;
    }

    public void setEntrance(Integer entrance) {
        this.entrance = entrance;
    }

    public Integer getExeunt() {
        return exeunt;
    }

    public void setExeunt(Integer exeunt) {
        this.exeunt = exeunt;
    }

    public Integer getWorkConfirm() {
        return workConfirm;
    }

    public void setWorkConfirm(Integer workConfirm) {
        this.workConfirm = workConfirm;
    }

    public Integer getiDCardPDF() {
        return iDCardPDF;
    }

    public void setiDCardPDF(Integer iDCardPDF) {
        this.iDCardPDF = iDCardPDF;
    }

    public Integer getIsTrain() {
        return isTrain;
    }

    public void setIsTrain(Integer isTrain) {
        this.isTrain = isTrain;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getIdphotoScan() {
        return idphotoScan;
    }

    public void setIdphotoScan(String idphotoScan) {
        this.idphotoScan = idphotoScan;
    }

    public String getIdphotoScan2() {
        return idphotoScan2;
    }

    public void setIdphotoScan2(String idphotoScan2) {
        this.idphotoScan2 = idphotoScan2;
    }

    public String getBankCardUrl() {
        return bankCardUrl;
    }

    public void setBankCardUrl(String bankCardUrl) {
        this.bankCardUrl = bankCardUrl;
    }
}
