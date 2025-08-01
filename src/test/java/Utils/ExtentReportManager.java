package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Cucumber-Selenium Test Results");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
