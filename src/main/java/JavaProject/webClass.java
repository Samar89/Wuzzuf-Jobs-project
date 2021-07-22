/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

/**
 *
 * @author samar
 */

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController; 

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

@SpringBootApplication

@RestController
public class webClass {
    public static void main(String[] args) {
        SpringApplication.run (JobsApplication.class, args);
    } 

    @GetMapping("/Jobs-project")
    public String hello(@RequestParam(value = "name", defaultValue = "Samar") String name) {
        String header = "<h1 style='text-align:center; margin-bottom:10px'>Wuzzuf Jobs Analysis</h1>";
        
        String getDataInTable = "<table border='1'><tr><td>Title</td><td>Company</td><td>Location</td><td>Type</td><td>Level</td><td>YearsExp</td><td>Country</td><td>Skills</td></tr>";

        ReadCsvFileIntoSparkSql csvSpark = new ReadCsvFileIntoSparkSql();

        List<Jobs> alljobs = csvSpark.getData();

        for(Jobs job:alljobs) {
            getDataInTable += "<tr><td>"+job.getTitle()+"</td><td>"+job.getCompany()+"</td><td>"+job.getLocation()+"</td><td>"+job.getType()+"</td><td>"+job.getLevel()+"</td><td>"+job.getYearsExp()+"</td><td>"+job.getCountry()+"</td><td>"+job.getSkills()+"</td></tr>";
        }
        
        getDataInTable +="</table>";
        
        Dataset<Row> csvDataFrame = csvSpark.getCsvFile();
        
        

        return "<html><head><title>Wuzzuf Jobs</title></head><body>"+header+"<h2>First 10 row of data:</h2>"+getDataInTable+"<h2>Schema:</h2><pre>"+csvDataFrame.schema()+"</pre><h2>Describtion:</h2><pre>"+csvDataFrame.describe()+"</pre></body></html>";
    }
}