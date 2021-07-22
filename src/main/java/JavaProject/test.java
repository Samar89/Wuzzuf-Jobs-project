/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

import java.util.List;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.SparkContext;
import org.apache.spark.SparkConf;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author samar
 */
public class test {
    public static void main(String[] args) {
        String HtmlCode = "";
//        SpringApplication.run(JavaFinalProjectApplication.class, args);
        ReadCsvFileIntoSparkSql getData = new ReadCsvFileIntoSparkSql();
        
        List<Jobs> alljobs = getData.getData();
        
        for(Jobs j:alljobs) {
            HtmlCode += j.getTitle();
        }
        
        System.out.println(HtmlCode);
    }

}
