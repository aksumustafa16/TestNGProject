package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){
        //create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","Sheet1");

        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());
        System.out.println("qa3short.getCellData(2,3) = " + qa3short.getCellData(2, 3));
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());
        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);
        }


    }

}
