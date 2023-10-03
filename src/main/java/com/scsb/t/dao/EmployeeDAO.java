package com.scsb.t.dao;

import com.scsb.t.entity.EmployeeLogin;
import com.scsb.t.entity.WirelessDeviceForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO  {
    void save(EmployeeLogin employeeLogin);
    EmployeeLogin findById(String Emp_id);
    List<EmployeeLogin> findAll();
    List<EmployeeLogin> findAllByEmpId(String Emp_id);
    Boolean checkAccount(EmployeeLogin employeeLogin);
}
