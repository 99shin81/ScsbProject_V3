package com.scsb.t.service;

import com.scsb.t.entity.State;
import com.scsb.t.entity.WirelessDeviceForm;
import com.scsb.t.pojo.temp;

import java.io.FileNotFoundException;
import java.util.List;

public interface StateService {

    // 新建表單時站點更新
    String stateUpdate_newForm(temp t);

    List<State> findByCurrentEmpId(String current_emp_id);

    String stateUpdate_oldForm(temp t);
}
