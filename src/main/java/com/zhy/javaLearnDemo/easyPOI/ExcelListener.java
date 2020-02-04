package com.zhy.javaLearnDemo.easyPOI;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ExcelListener
 * @Description: TODO 留下注释吧
 * @Date: 2019/12/24 22:40
 * @Version: 1.0
 **/
@Data
public class ExcelListener extends AnalysisEventListener<EpYearExplorationPlanning> {

    private List<EpYearExplorationPlanning> datas = new ArrayList<EpYearExplorationPlanning>();

    @Override
    public void invoke(EpYearExplorationPlanning epYearExplorationPlanning, AnalysisContext analysisContext) {
        System.out.println("当前行："+analysisContext.getCurrentRowNum());

        if (epYearExplorationPlanning.getSequenceNo()!=null) {
            datas.add(epYearExplorationPlanning);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        }
        //doSomething(object);//根据自己业务做处理

    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("解析完成");
    }
}
