package com.scsb.t.service;

import com.scsb.t.pojo.temp;

import com.scsb.t.dao.TemplateDAO;
import com.scsb.t.dao.StateDAO;
import com.scsb.t.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scsb.t.pojo.temp;

import java.util.List;


@Service
public class StateServiceImpl implements StateService {

    @Autowired
    TemplateDAO allStateDAO;
    @Autowired
    StateDAO stateDAO;

    // 新建表單時站點更新
    @Override
    // public String stateUpdate_newForm(WirelessDeviceForm w) {
    public String stateUpdate_newForm(temp t) {
        String[] formData = t.formInfo().split(" ");

        String formName = formData[0];
        Long formId = Long.parseLong(formData[1]);
        String formAllState = formData[2];
        System.out.println(formId);

        if (formName.equals("WirelessDeviceForm")) {

            if (formAllState.equals("-")) {
                System.out.println("更新了 WirelessDeviceForm 的原始表單 - ID:" + formId + "的站點");
                State state = new State(formId, "", 0, "done", formAllState);
                stateDAO.save(state);
                return "State Update Ok";
            } else {
                System.out.println("更新了 WirelessDeviceForm 的自訂簽核人員表單 - ID:" + formId + "的站點");
                String[] EmpId = formAllState.split(",");
                State state = new State(formId, EmpId[0], 0, "processing", formAllState);
                stateDAO.save(state);
                return "State Update Ok";
            }
        }
        return "State Update Failed";
    }

    @Override
    public List<State> findByCurrentEmpId(String current_emp_id) {
        // TODO Auto-generated method stub
        return stateDAO.findByCurrentEmpId(current_emp_id);

    }

    @Override
    public String stateUpdate_oldForm(temp t) {
        String[] formData = t.formInfo().split(" ");
        String formName = formData[0];
        Long formId = Long.parseLong(formData[1]);

        State state = stateDAO.findByFormId(formId);
        System.out.println("有找到=" + state.getAllState());
        String nowState = state.getNowState();

        if (formName.equals("WirelessDeviceForm")) {
            if (nowState.equals("done")) {
                System.out.println("WirelessDeviceForm" + formId + "此表單已完成，無須簽核");
                return "State Update Failed";
            } else if (nowState.equals("processing")) {
                String[] allState = state.getAllState().split(",");
                Integer nowStage = state.getNowStage();
                nowStage = nowStage + 1;
                String currentEmpId;
                if (nowStage == allState.length) {
                    nowState = "done";
                    currentEmpId = null;
                } else {
                    currentEmpId = allState[nowStage];
                }
                stateDAO.dbUpdate_sign(formId, currentEmpId, nowStage, nowState);
                System.out.println("WirelessDeviceForm" + formId + "此表單站點已更新");
                return "State Update Ok";
            } else {
                System.out.println("WirelessDeviceForm" + formId + "此表單於資料庫中的處理狀態未知");
                return "State Update Failed";
            }
        }
        return "State Update Failed";
    }
}
