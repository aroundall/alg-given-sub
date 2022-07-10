package org.amuji.alg.givensum;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please input the name of the file which contains the numbers:");
            String fileName = scanner.nextLine();

            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.printf("The loaded values from file: %s.%n", String.join(", ", lines));

            System.out.println("Please input the target number (sum):");
            String theTarget = scanner.nextLine();

            DecimalSumCombinationsFinder finder = new DecimalSumCombinationsFinder(
                    new BigDecimal(theTarget),
                    lines.stream().map(BigDecimal::new).collect(toList()));

            System.out.println("The combinations of the target sum as below:");
            finder.getCombinations().forEach(System.out::println);

            Files.write(Paths.get("./combinations.txt"),
                    finder.getCombinations()
                            .stream().map(c -> c.toString())
                            .reduce((a, b) -> a + "\n" + b)
                            .get().getBytes(StandardCharsets.UTF_8));
            System.out.println("The combinations have been saved to combinations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
