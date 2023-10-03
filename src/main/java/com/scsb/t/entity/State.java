package com.scsb.t.entity;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "state")
@EntityListeners(AuditingEntityListener.class)
@Data
public class State {
    @Id
    @Column(name = "form_id")  // 表單ID
    private Long formId;

    @Column(name = "current_emp_id")
    private String currentEmpId; // 待簽核人員

    @Column(name = "now_stage")
    private Integer nowStage; // 現在站點

    @Column(name = "now_state")
    private String nowState; // 現在情形：1.done, 2.processing

    @Column(name = "all_state")
    private String allState; // 所有簽核人員

    //建構子


    public State(Long formId, String currentEmpId, Integer nowStage, String nowState, String allState) {
        this.formId = formId;
        this.currentEmpId = currentEmpId;
        this.nowStage = nowStage;
        this.nowState = nowState;
        this.allState = allState;
    }

    public State() {
    }

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getCurrentEmpId() {
		return currentEmpId;
	}

	public void setCurrentEmpId(String currentEmpId) {
		this.currentEmpId = currentEmpId;
	}

	public Integer getNowStage() {
		return nowStage;
	}

	public void setNowStage(Integer nowStage) {
		this.nowStage = nowStage;
	}

	public String getNowState() {
		return nowState;
	}

	public void setNowState(String nowState) {
		this.nowState = nowState;
	}

	public String getAllState() {
		return allState;
	}

	public void setAllState(String allState) {
		this.allState = allState;
	}
}
