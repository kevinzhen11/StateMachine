package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void main(String[] args) throws IOException {
        print(args[0], args[1]);
    }

    /**
     * print
     * @param stateFile
     * @param inputsFile
     * @throws IOException
     */
    public static void print(String stateFile, String inputsFile) throws IOException {

        // construct state machine according to state file
        StateMachine stateMachine = new StateMachine(stateFile);

        List<String> inputes = getInputsFromFileName(inputsFile);
        for (String input: inputes) {
            System.out.println(stateMachine.validate(input));
        }
    }

    /**
     * get all inputs as string list
     * @param fileName
     * @return
     * @throws IOException
     */
    private static List<String> getInputsFromFileName(String fileName) throws IOException {
        List<String> res = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            res.add(line);
        }
        return res;
    }
}
