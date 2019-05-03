package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StateMachine {
    List<Rule> rules = new ArrayList<>();
    StateMachine(String fileName) throws IOException {
        constructAllStates(new File(fileName));
    }

    /**
     * constrcu states
     * @param file
     * @throws IOException
     */
    void constructAllStates(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] args = line.split(" ");
            rules.add(new Rule(args[0], args[1], args[2]));
        }

    }

    /**
     * find the rule mapped statenumber and currentstate in rules
     * @param stateNumber
     * @param currentState
     * @return
     */
    Rule findRule(String stateNumber, String currentState) {
        for (Rule rule: rules) {
            if (rule.inputCharacter.equals(stateNumber) && rule.stateNumber.equals(currentState)) {
                return rule;
            }
        }
        return null;
    }

    /**
     * validate the input and process it using state machine
     * @param input
     * @return
     */
    public String validate(String input) {
        List<String> chars = Arrays.asList(input.split(""));
        String currentState = "0";
        int i = 0;
        for (String cha: chars) {
            i += 1;
            Rule rule = findRule(cha, currentState);
            if (rule == null) {
                return String.format("Failure at position %s, found character %s.", i, cha);
            }

            currentState = rule.transitionsToState;
            if ("999".equals(currentState) && i != chars.size()) {
                return "Input string ended before success transition.";
            }
        }

        return "Success";
    }
}

