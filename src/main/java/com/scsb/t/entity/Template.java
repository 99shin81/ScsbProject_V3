package com.scsb.t.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "template")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Template {
    @Id
    @Column(name = "form_name")  //
    private String formName;

    @Column(name = "state_num")
    private Integer stateNum; //

    @Column(name = "all_state")
    private String allState; //

    public Template(String formName, Integer stateNum, String allState) {
        this.formName = formName;
        this.stateNum = stateNum;
        this.allState = allState;
    }

    public Template(){

    }
}

