package com.scsb.t.dao;

import com.scsb.t.entity.WirelessDeviceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormDAO extends JpaRepository<WirelessDeviceForm, Long> {
    @Query(value = "select * from Device where emp_id = ?1", nativeQuery = true)
    List<WirelessDeviceForm> findByEmpId(String emp_id);

    @Query(value = "select * from device where form_id= ?1", nativeQuery = true)
    WirelessDeviceForm findByFormId(Long formId);




}