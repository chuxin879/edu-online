package com.guodong.eduservice.entity;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.List;

public class DemoData {
    public static void main(String[] args){
        String fileName = "D:\\test.xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("写入方法一").doWrite(data());
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("写入方法二").build();
        excelWriter.write(data(), writeSheet);
        excelWriter.finish();
    }



    //设置表头名称
    @ExcelProperty("学生姓名")
    private String name;

    @ExcelProperty("学生编号")
    private int sno;

    public String getName() {
        return name;
    }

    public int getSno() {
        return sno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "name='" + name + '\'' +
                ", sno=" + sno +
                '}';
    }

    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for(int i = 0; i<10; i++){
            DemoData data = new DemoData();
            data.setSno(i);
            data.setName("张三" + i);
            list.add(data);

        }
        return  list;
    }
}
