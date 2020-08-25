package pl.javalearn.weekop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag(value = "model")
public interface ModelTest {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }

}