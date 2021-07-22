/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.SparkContext;
import org.apache.spark.SparkConf;
import java.util.*;
/**
 *
 * @author samar
 */
public class ReadCsvFileIntoSparkSql {
    public SparkSession initSparkSession(){
        final SparkSession sparkSession = SparkSession.builder ().appName ("Spark CSV Analysis Demo").master ("local[2]").getOrCreate ();
        return sparkSession;
    }
    public Dataset<Row> getCsvFile(){
        SparkSession sparkSession = initSparkSession();

        final DataFrameReader dataFrameReader = sparkSession.read ();

        dataFrameReader.option ("header", "true");
        
        final Dataset<Row> csvDataFrame = dataFrameReader.format("csv").load("src/main/resources/Wuzzuf_Jobs.csv");
        
        return csvDataFrame;
    }
    
    public List<Jobs> getData() {
        
        SparkSession sparkSession = initSparkSession();
        
        List<Jobs> allJobs = new ArrayList<Jobs>();
 
        Dataset<Row> csvDataFrame = getCsvFile();
        
        csvDataFrame.createOrReplaceTempView("AllJobsData");
        
        Dataset<Row> getjobs = sparkSession.sql("select Title,Company,Location,Type,Level,YearsExp,Country,Skills from AllJobsData limit 10 "); 
        
     
        List<Row> jobsList = getjobs.collectAsList();

	for (Row row : jobsList) {
            allJobs.add(new Jobs(row.getString(0),row.getString(1),row.getString(2),row.getString(3),row.getString(4),row.getString(5),row.getString(6),row.getString(7)));
        }

        return allJobs;
    }

}
