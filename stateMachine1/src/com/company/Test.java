package com.company;

import java.io.File;
import java.io.IOException;

public class Test {
    /**
     * Test files
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Validator.main(new String[]{
                String.format("files%smyStateMachine.txt", File.separatorChar),
                String.format("files%smyInputs.txt", File.separatorChar)
        });

        testFailure();
        testSuccess();
        testEndedBeforeSuccess();
    }

    static void testFailure() throws IOException {
        StateMachine stateMachine = new StateMachine(String.format("files%smyStateMachine.txt", File.separatorChar));
        if (!stateMachine.validate("abc").equals("Failure at position 3, found character c.")) {
            throw new RuntimeException("assert failed");
        }
    }

    static void testSuccess() throws IOException {
        StateMachine stateMachine = new StateMachine(String.format("files%smyStateMachine.txt", File.separatorChar));
        if (!stateMachine.validate("abC").equals("Success")) {
            throw new RuntimeException("assert failed");
        }
    }

    static void testEndedBeforeSuccess () throws IOException {
        StateMachine stateMachine = new StateMachine(String.format("files%smyStateMachine.txt", File.separatorChar));
        if (!stateMachine.validate("abCxjf").equals("Input string ended before success transition.")) {
            throw new RuntimeException("assert failed");
        }
    }
}
