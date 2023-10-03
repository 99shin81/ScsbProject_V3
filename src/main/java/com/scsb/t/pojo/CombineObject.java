package com.scsb.t.pojo;

import com.scsb.t.entity.State;
import com.scsb.t.entity.WirelessDeviceForm;

public class CombineObject {
    public WirelessDeviceForm wirelessDeviceForm;
    public State state;

    CombineObject(){
    }

    public CombineObject(WirelessDeviceForm w, State s) {
        System.out.println("Enter61515165"+w.getEmpId());
        this.wirelessDeviceForm=w;
        this.state=s;
    }

}

