package com.guo.coder;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.List;

public class DemoData {
    //设置表头名称
    @ExcelProperty("学生编号")
    private int sno;

    @ExcelProperty("学生姓名")
    private String sname;

    public int getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                '}';
    }

    private static List<DemoData> data(){
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++){
            DemoData  data = new DemoData();
            data.setSno(i);
            data.setSname("张三" + i);
            list.add(data);

        }
        return list;

    }

    public static void main(String[] args) throws Exception{
        String fileName = "D:\\test.xlsx";
        //第一种写入方法
        EasyExcel.write(fileName, DemoData.class).sheet("写入方法一").doWrite(data());
//        第二种写入方法
        String fileName2 = "test2.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName2, DemoData.class).build();
        WriteSheet writerSheet = EasyExcel.writerSheet("写入方法2").build();
        excelWriter.write(data(), writerSheet);
        //finish关闭流
        excelWriter.finish();
        System.out.println("assss");



    }


}
