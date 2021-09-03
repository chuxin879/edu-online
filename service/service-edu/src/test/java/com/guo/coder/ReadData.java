package com.guo.coder;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadData {
    @ExcelProperty(index = 0)
    private int sid;

    @ExcelProperty(index = 1)
    private String sname;

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "ReadData{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }


}
