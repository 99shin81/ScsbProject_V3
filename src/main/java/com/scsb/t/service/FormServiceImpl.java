package com.scsb.t.service;

import com.scsb.t.dao.FormDAO;
import com.scsb.t.entity.WirelessDeviceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService{
    @Autowired
    private FormDAO formDAO;

    @Override
    public WirelessDeviceForm saveWirelessDeviceForm(WirelessDeviceForm wirelessDeviceForm) {
        System.out.println("data loading");
        return formDAO.save(wirelessDeviceForm);
    }

    @Override
    public List<WirelessDeviceForm> findAll() {
        return formDAO.findAll();
    }

    @Override
    public List<WirelessDeviceForm> findByEmpId(String EmpId) {

        return formDAO.findByEmpId(EmpId);
    }

    @Override
    public WirelessDeviceForm findByFormId(Long formId) {

        // TODO Auto-generated method stub
        return formDAO.findByFormId(formId);
    }


}
