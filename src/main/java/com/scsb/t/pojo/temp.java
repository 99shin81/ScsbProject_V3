package com.scsb.t.pojo;

public class temp<T> {
    public T t;

    public temp(T t) {
        this.t = t;
    }

    public String formInfo(){
        return t.toString();
    }
}
