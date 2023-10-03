package com.scsb.t.controller;

import com.scsb.t.entity.State;
import com.scsb.t.entity.WirelessDeviceForm;
import com.scsb.t.pojo.CombineObject;
import com.scsb.t.pojo.temp;
import com.scsb.t.service.FormService;

import com.scsb.t.service.StateService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.*;

@RestController
public class FormRestController {
    @Autowired
    private FormService formService;
    @Autowired
    private StateService stateService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginpage() {
        ModelAndView mv = new ModelAndView("loginpage");
        return mv;
    }

    @RequestMapping("/fail")
    @ResponseBody
    public String fail(){
        return "fail";
    }

    @RequestMapping("/redirectToIndex")
    public String redirectToIndex() {
        return "redirect:/index.html";
    }

    @RequestMapping("/redirectToLogin")
    public String redirectToLogin() {
        return "redirect:/loginpage.html";
    }

    @RequestMapping("/redirectToListForm")
    public String redirectToListForm() {
        return "redirect:/api/findAll";
    }

    @RequestMapping("/redirectToListForm1")
    public String redirectToListForm1() {
        return "redirect:/api/findByEmpId";
    }


    @RequestMapping("/listForms")
    public ModelAndView listForms(Model model) {

        return new ModelAndView("listForms");
    }


    @RequestMapping(value = "api/getParam", method = RequestMethod.POST)
    public String getParam(
            @RequestParam String applyDate,
            @RequestParam String user,
            @RequestParam String identify,
            @RequestParam String FormEmpId,
            @RequestParam String useDate,
            @RequestParam String equipment,
            @RequestParam String os,
            @RequestParam String macAddress,
            @RequestParam String ssid,
            @RequestParam String account,
            @RequestParam String ip,
            @RequestParam String sign1,
            @RequestParam String sign2,
            @RequestParam String sign3,
            @ModelAttribute WirelessDeviceForm w) {

        String allState = sign1 + "," + sign2 + "," + sign3;

        w.setApplyDate(applyDate);
        w.setApplicant(user);
        w.setIdentify(identify);
        w.setEmpId(FormEmpId);
        w.setUseDate(useDate);
        w.setEquipment(equipment);
        w.setOs(os);
        w.setMacAddress(macAddress);
        w.setSsid(ssid);
        w.setAccount(account);
        w.setIp(ip);
        w.setAllState(allState);

        w = formService.saveWirelessDeviceForm(w);
        // 新增此表單的簽核站點
        temp<WirelessDeviceForm> t = new temp<>(w); // 0919-k
        stateService.stateUpdate_newForm(t); // 0919-k

        return "接收的資料，Form ID:" + w.getFormId() + " Application:" + user ; // 返回的視圖名稱，例如 "resultView.html"
    }

    @RequestMapping("api/sendParam")
    public ModelAndView sendParam() {
        ModelAndView mv = new ModelAndView("sendParam");
        mv.getModel().put("WirelessDeviceForm", new WirelessDeviceForm());
        return mv;
    }

    @RequestMapping(value = "api/findAll", method = RequestMethod.GET)
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("listForms");
        List<WirelessDeviceForm> AllForms = formService.findByEmpId("E001");
        mv.addObject("form", AllForms);
        mv.addObject("SUCCESS", "Y");
        return mv;
    }

    @RequestMapping(value = "/api/findByEmpId", method = RequestMethod.GET)
    public ModelAndView findByEmpId(@RequestParam("empIdData") String EmpId) {
        ModelAndView mv = new ModelAndView("listForms");
        List<WirelessDeviceForm> getFormsByEmpId = formService.findByEmpId(EmpId);
        mv.addObject("form", getFormsByEmpId);
        mv.addObject("SUCCESS", "Y");
        return mv;
    }

    @RequestMapping(value = "/api/findByCurrentEmpId", method = RequestMethod.GET)
    public ModelAndView findByCurrentEmpId(@RequestParam("empIdData") String EmpId) {
        ModelAndView mv = new ModelAndView("listFormTest");

        List<State> AllStates = stateService.findByCurrentEmpId(EmpId);
        System.out.println("outer=" + AllStates.size());
        List<WirelessDeviceForm> getFormsByFormId = new ArrayList<WirelessDeviceForm>();
        for (State s : AllStates) {
            System.out.println("inner=" + formService.findByFormId(s.getFormId()));
            getFormsByFormId.add(formService.findByFormId(s.getFormId()));

        }
        List<CombineObject> combinedObjects = new ArrayList<>();
        for (int i = 0; i < Math.min(getFormsByFormId.size(), AllStates.size()); i++) {
            combinedObjects.add(new CombineObject(getFormsByFormId.get(i), AllStates.get(i)));
        }

        mv.addObject("form", combinedObjects);

        return mv;
    }

//    // 測試回傳json
//    @RequestMapping(value = "/api/returnInfo", method = RequestMethod.GET)
//    @ResponseBody
//    public String returnJson(@RequestParam("formId") String FormId) throws JSONException {
//        System.out.println("FormId=" + FormId);
//        JSONObject ret = new JSONObject();
//        ret.put("allstate", "E005-E003-E001");
//        ret.put("now_stage", 1);
//        return ret.toString();
//        // return "[{nmae:123,age:23}]";
//    }

    // 簽核
    @RequestMapping(value = "/api/signForm", method = RequestMethod.GET)
    public String signForm(@RequestParam("formInfo") String formInfo) {

        System.out.println("success enter /api/signForm,formInfo=" + formInfo);
        temp<String> t = new temp<>(formInfo);
        stateService.stateUpdate_oldForm(t);
        return "success";
    }


//    @RequestMapping(value = "/api/findByCurrentEmpId", method = RequestMethod.GET)
//    public ModelAndView findByCurrentEmpId(@RequestParam("empIdData") String EmpId) {
//        ModelAndView mv = new ModelAndView("listForms");
//        List<WirelessDeviceForm> getFormsByEmpId = formService.findByCurrentEmpId("E010");
//        mv.addObject("form", getFormsByEmpId);
//        mv.addObject("SUCCESS", "Y");
//        return mv;
//    }

//    @RequestMapping(value = "api/findByEmpId", method = RequestMethod.POST)
//    public ModelAndView receiveEmpIdData(@RequestBody EmpIdDataDTO empIdDataDTO) {
//        // At this point, the data from the AJAX request has already been converted into the EmpIdDataDTO object
//        String empId = empIdDataDTO.getEmpIdData();
//
//        ModelAndView mv = new ModelAndView("listForms");
//        List<WirelessDeviceForm> getFormsByEmpId = formService.findByEmpId(empId);
//        mv.addObject("form", getFormsByEmpId);
//        mv.addObject("SUCCESS", "Y");
//        return mv;
//    }














//    @GetMapping("/form/{EmpId}")
//    public WirelessDeviceForm getFormsByEmpId(@PathVariable int EmpId){
//        return theForm.get(EmpId);
//    }

//    @Autowired
//    FormRegister formRegister;

//    @GetMapping( "/register")
//    public String GetData(
//            @RequestParam("applicant")String applicant,
//            @RequestParam("empid")String empid,
//            @RequestParam("identify")String identify,
//            @RequestParam("applydate")String applydate,
//            @RequestParam("usedate")String usedate,
//            @RequestParam("equipment")String equipment,
//            @RequestParam("os")String os,
//            @RequestParam("macaddress")String macaddress,
//            @RequestParam("ssid")String ssid,
//            @RequestParam("account")String account,
//            @RequestParam("ip")String ip
//    ) throws SQLException {
//        formRegister.insertDB(applicant, empid, identify, applydate, usedate, equipment, os, macaddress, ssid, account, ip);
//        return "All Data Storing to DB";
//    }




}
