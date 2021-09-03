package com.guo.coder;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelListener extends AnalysisEventListener<ReadData> {

    List<ReadData> list = new ArrayList<ReadData>();

    //一行 一行读取Excel内容
    @Override
    public void invoke(ReadData user, AnalysisContext analysisCOntext){
        System.out.println("***"+user);
        list.add(user);
    }

    //读取Excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext analysisContext){
        System.out.println("表头信息" + headMap);
    }


    //读取完成后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext){

    }
    //调用最终的读取
    public static void main (String[] args) throws Exception{
        String fileName = "D:\\test.xlsx";
        //写法一
        //指定用那个classa去读，然后读取第一个sheet，文件陆会自动关闭
        EasyExcel.read(fileName, ReadData.class, new ExcelListener()).sheet().doRead();

        //写法二
        InputStream in  = new BufferedInputStream(new FileInputStream("D:\\test.xlsx"));
        ExcelReader excelReader = EasyExcel.read(in, ReadData.class, new ExcelListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        //关闭流,必须、读的时候会缠身临时文件
        excelReader.finish();

    }
}
