package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        try (
                Scanner scanner = new Scanner(new BufferedReader(new FileReader("homeworkInputFile.txt")));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("homeworkOutputFile.txt"));
                ) {

            String textString = "";
            Integer stringNumber = null;
            HashMap<Integer, String> strings = new HashMap<>();

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    if (stringNumber != null) {
                        strings.put(stringNumber, textString);
                    }
                    stringNumber = scanner.nextInt();
                    textString = "";
                } else {
                    textString += scanner.next() + " ";
                }
            }
            strings.put(stringNumber, textString);

            for (int i = 1; i <= strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
            }
        }
    }
}
