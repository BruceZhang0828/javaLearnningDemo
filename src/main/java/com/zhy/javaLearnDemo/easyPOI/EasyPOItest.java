package com.zhy.javaLearnDemo.easyPOI;



import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EasyPOItest
 * @Description: TODO 留下注释吧
 * @Date: 2019/12/24 14:56
 * @Version: 1.0
 **/
public class EasyPOItest {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("E:\\工作文档\\A13.0流程\\数据.xlsx"));
        // 解析每行结果在listener中处理
        AnalysisEventListener listener = new ExcelListener();
        //ExcelReader excelReader = new ExcelReader(inputStream, null, listener);
        ExcelReader excelReader = EasyExcel.read(inputStream).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).head(EpYearExplorationPlanning.class).headRowNumber(3).registerReadListener(listener).build();
        excelReader.read(readSheet);
        List<EpYearExplorationPlanning> datas = ((ExcelListener) listener).getDatas();
        System.out.println(datas.size());


    }
}
