package com.scsb.t.entity;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Device")
@EntityListeners(AuditingEntityListener.class)
@Data
public class WirelessDeviceForm {
    //主鍵由資料庫自動維護(AUTO_INCREMENT)，是此資料表的Primary Key@GeneratedValue(strategy = GenerationType.IDENTITY)
    //告訴此Column的生成方式。
    //GenerationType.AUTO 讓容器來自動產生
    //GenerationType.IDENTITY 讓資料庫自己維護
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")  // 修改此處
    private Long formId;

    @Column(name = "applicant")
    private String applicant; //申請人

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "identify")
    private String identify;

    @Column(name = "apply_date")
    private String applyDate;

    @Column(name = "use_date")
    private String useDate;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "os")
    private String os;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "ssid")
    private String ssid;

    @Column(name = "account")
    private String account;

    @Column(name = "ip")
    private String ip;

    @Column(name = "all_State")
    private String allState;


    //建構子
    public WirelessDeviceForm(){}
    // 0920-k delete formId

    public WirelessDeviceForm(String applicant, String empId, String identify, String applyDate, String useDate, String equipment, String os, String macAddress, String ssid, String account, String ip, String allState) {
        this.applicant = applicant;
        this.empId = empId;
        this.identify = identify;
        this.applyDate = applyDate;
        this.useDate = useDate;
        this.equipment = equipment;
        this.os = os;
        this.macAddress = macAddress;
        this.ssid = ssid;
        this.account = account;
        this.ip = ip;
        this.allState = allState;
    }

//    public WirelessDeviceForm(Long formId, String applicant, String empId, String identify, String applyDate, String useDate, String equipment, String os, String macAddress, String ssid, String account, String ip) {
//        this.formId = formId;
//        this.applicant = applicant;
//        this.empId = empId;
//        this.identify = identify;
//        this.applyDate = applyDate;
//        this.useDate = useDate;
//        this.equipment = equipment;
//        this.os = os;
//        this.macAddress = macAddress;
//        this.ssid = ssid;
//        this.account = account;
//        this.ip = ip;
//    }


    @Override
    public String toString() {
        return "WirelessDeviceForm" + " "
                + formId + " "
                + allState;
    }

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAllState() {
		return allState;
	}

	public void setAllState(String allState) {
		this.allState = allState;
	}
}
