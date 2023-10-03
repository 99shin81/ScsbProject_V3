package com.scsb.t.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="Employee")
@Data
public class EmployeeLogin {

    @Id
    @Column(name="Emp_id")
    private String Emp_id;

    @Column(name="Password")
    private String Password;

    @Column(name="Account")
    private String Account;

    public EmployeeLogin(String emp_id, String account,  String password) {
        Emp_id = emp_id;
        Password = password;
        Account = account;
    }

    public EmployeeLogin() {

    }

    @Override
    public String toString() {
        return "EmployeeLogin{" +
                "Emp_id='" + Emp_id + '\'' +
                ", Password='" + Password + '\'' +
                ", Account='" + Account + '\'' +
                '}';
    }

	public String getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(String emp_id) {
		Emp_id = emp_id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}
}

