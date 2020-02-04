package com.zhy.javaLearnDemo.easyPOI;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EpYearExplorationPlanning {
    private String id;

    @ExcelProperty(index = 0)
    private Integer sequenceNo;

    private Integer year;

    private String oilField;

    private String planBatch;

    private String planEnd;

    private Date adjustDate;
    @ExcelProperty(index = 1)
    private String activityName;
    @ExcelProperty(index = 2)
    private String subActivityName;
    @ExcelProperty(index = 3)
    private String geoZone;
    @ExcelProperty(index = 4)
    private String geoType;
    @ExcelProperty(index = 5)
    private BigDecimal lineLength2d;
    @ExcelProperty(index = 6)
    private BigDecimal lineCost2d;
    @ExcelProperty(index = 7)
    private BigDecimal lineInvestment2d;
    @ExcelProperty(index = 8)
    private BigDecimal seismicArea3d;
    @ExcelProperty(index = 9)
    private BigDecimal seismicCost3d;
    @ExcelProperty(index = 10)
    private BigDecimal seismicInvestment3d;
    @ExcelProperty(index = 11)
    private BigDecimal seismicInvestment;
    @ExcelProperty(index = 12)
    private BigDecimal nonSeismicPrjInvestment;
    @ExcelProperty(index = 13)
    private Integer regionExplorationWellNum;
    @ExcelProperty(index = 14)
    private BigDecimal regionExplorationWellFootage;
    @ExcelProperty(index = 15)
    private Integer prospectWellNum;
    @ExcelProperty(index = 16)
    private BigDecimal prospectWellFootage;
    @ExcelProperty(index = 17)
    private Integer assessWellNum;
    @ExcelProperty(index = 18)
    private BigDecimal assessWellFootage;
    @ExcelProperty(index = 19)
    private Integer totalWellSumNum;
    @ExcelProperty(index = 20)
    private Integer unbalanceWellSumNum;
    @ExcelProperty(index = 21)
    private Integer horizonWellSumNum;
    @ExcelProperty(index = 22)
    private BigDecimal totalWellSumFootage;
    @ExcelProperty(index = 23)
    private BigDecimal unbalanceWellSumFootage;
    @ExcelProperty(index = 24)
    private BigDecimal horizonWellSumFootage;
    @ExcelProperty(index = 25)
    private BigDecimal totalWellCost;
    @ExcelProperty(index = 26)
    private BigDecimal unbalanceWellSumCost;
    @ExcelProperty(index = 27)
    private BigDecimal horizonWellSumCost;
    @ExcelProperty(index = 28)
    private BigDecimal totalWellInvestment;

    private Integer geologyWellNum;

    private BigDecimal geologyWellFootage;

    private BigDecimal unbalanceWellSumInvest;

    private BigDecimal horizonWellSumInvest;

    private BigDecimal otherInvestment;

    private BigDecimal totalExplorationInvestment;

    private Integer provedOilGeologicalReserve;

    private BigDecimal provedOilRecoverableReserve;

    private BigDecimal provedGasGeologicalReserve;

    private BigDecimal provedGasRecoverableReserve;

    private Integer probableOilGeologicalReserve;

    private Integer probableOilRecoverableReserve;

    private BigDecimal probableGasGeologicalReserve;

    private BigDecimal probableGasRecoverableReserve;

    private Integer possibleOilGeologicalReserve;

    private Integer possibleOilRecoverableReserve;

    private BigDecimal possibleGasGeologicalReserve;

    private BigDecimal possibleGasRecoverableReserve;

    private String bsFlag;

    private String remarks;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;



}
