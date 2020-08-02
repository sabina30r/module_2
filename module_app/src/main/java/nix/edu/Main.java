package nix.edu;


import nix.edu.data.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {

    static List<String> listOfDates = Arrays.asList(
            "2020-04-05",
            "2020/04/05",
            "04/05/2020",
            "202020/04/05"
    );
    static List<String> listOfNames = Arrays.asList("Mary", "Ann", "Helen", "Ann", "Mary", "Olga");

    public static void main(String[] args) throws IOException {

        System.out.println("----------------------------------TASK 1----------------------------------");

        System.out.println("Converted list of valid dates: " + FirstTaskUtil.convertDateList(listOfDates));

        System.out.println("----------------------------------TASK 2----------------------------------");

        SecondTaskUtil.findFirstUniqueString(listOfNames);

        File output = new File("output.txt");
        if (!output.exists()) {
            output.createNewFile();
        }

        Reader.readData();
        List<Node> graph = Reader.getGraph();
        Map<String, String> distance = Reader.getDistance();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {

            for (String from : distance.keySet()) {
                Node fromNode = ThirdTaskUtil.getNodeByName(graph, from);
                String to = distance.get(from);
                Node destNode = ThirdTaskUtil.getNodeByName(graph, to);
                ThirdTaskUtil.calculatePaths(graph, fromNode);
                bw.write("Shortest way from " + from + " to " + to + "= " + (int) destNode.minDistance + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
