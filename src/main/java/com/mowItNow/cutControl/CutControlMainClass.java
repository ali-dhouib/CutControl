package com.mowItNow.cutControl;

import com.mowItNow.cutControl.business.InputParser;
import com.mowItNow.cutControl.business.OutputParser;
import com.mowItNow.cutControl.business.Simulator;
import com.mowItNow.cutControl.business.reader.FileReader;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.domain.ParsedInput;

import java.util.List;

public class CutControlMainClass {
    /**
     * The Input file path.
     */
    static final String inputPath = "src/main/java/com/mowItNow/cutControl/inputFiles/input_file1.txt";
    // static final String inputPath = "src/main/java/com/mowItNow/cutControl/inputFiles/input_file2.txt";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<String> textCommands = FileReader.readFile(inputPath);
        ParsedInput input = InputParser.parse(textCommands);
        List<Mower> result = new Simulator().simulate(input);

        System.out.println(OutputParser.parse(result));
    }
}