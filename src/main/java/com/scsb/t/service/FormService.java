package com.scsb.t.service;

import com.scsb.t.entity.WirelessDeviceForm;

import java.util.List;

public interface FormService {
    WirelessDeviceForm saveWirelessDeviceForm(WirelessDeviceForm wirelessDeviceForm);
    List<WirelessDeviceForm> findAll();
    //Optional<WirelessDeviceForm> findOneByempId(String empId);
    List<WirelessDeviceForm> findByEmpId(String EmpId);

    WirelessDeviceForm findByFormId(Long formId);




}
