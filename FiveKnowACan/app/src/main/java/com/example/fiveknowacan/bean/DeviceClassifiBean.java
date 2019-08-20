package com.example.fiveknowacan.bean;

/**
 * 设备分类   包含：防护类、侦检类、洗消类等等
 *
 * @author cao
 *  * @date 2019-8-20
 */
public class DeviceClassifiBean {

    private int id;     //设备分类ID
    private String m_DeviceClassifiName;    //设备分类名称

    public DeviceClassifiBean(int id, String s){
        this.id = id;
        this.m_DeviceClassifiName = s;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setM_DeviceClassifiName(String m_DeviceClassifiName) {
        this.m_DeviceClassifiName = m_DeviceClassifiName;
    }

    public String getM_DeviceClassifiName() {
        return m_DeviceClassifiName;
    }
}
