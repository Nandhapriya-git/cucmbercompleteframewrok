package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.util.HashMap;
import java.util.Map;

public class ExtentReporterAdapter implements ConcurrentEventListener {

    private ExtentReports extent = ExtentReportManager.getInstance();
    private Map<String, ExtentTest> scenarioMap = new HashMap<>();
    private ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        ExtentTest test = extent.createTest(event.getTestCase().getName());
        scenarioMap.put(event.getTestCase().getId().toString(), test);
        currentTest.set(test);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        if (!(event.getTestStep() instanceof PickleStepTestStep)) return;

        PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
        io.cucumber.plugin.event.Status resultStatus = event.getResult().getStatus();
        ExtentTest test = currentTest.get();

        switch (resultStatus) {
            case PASSED:
                test.log(Status.PASS, step.getStep().getText());
                break;
            case FAILED:
                test.log(Status.FAIL, step.getStep().getText());
                if (event.getResult().getError() != null) {
                    test.log(Status.FAIL, event.getResult().getError().getMessage());
                }
                break;
            case SKIPPED:
                test.log(Status.SKIP, step.getStep().getText());
                break;
            default:
                test.log(Status.INFO, "Step status: " + resultStatus);
        }
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        extent.flush();
    }
}
