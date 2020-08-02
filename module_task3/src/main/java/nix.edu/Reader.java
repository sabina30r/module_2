package nix.edu;

import nix.edu.data.Edge;
import nix.edu.data.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

    private static File input = new File("input.txt");
    private static List<Node> graph = new ArrayList<>();
    private static Map<String, String> distance = new HashMap<>();

    public static void readData() {

        if (!input.exists()) {
            throw new IllegalArgumentException("There is no file with such name");
        } else {

            try (BufferedReader br = new BufferedReader(new FileReader(input))) {

                String first = br.readLine();
                int numberOfNodes = Integer.parseInt(first);

                for (int i = 1; i < numberOfNodes + 1; i++) {
                    int index = i;
                    String name = br.readLine();
                    String next = br.readLine();
                    int numberOfAdjacentNodes = Integer.parseInt(next);
                    List<Edge> list = new ArrayList<>();

                    for (int j = 0; j < numberOfAdjacentNodes; j++) {
                        String current = br.readLine();
                        String[] values = current.split(" ");
                        int currentIndex = Integer.parseInt(values[0]);
                        int currentWeight = Integer.parseInt(values[1]);
                        list.add(new Edge(currentIndex, currentWeight));
                    }

                    Edge[] edges = new Edge[list.size()];

                    for (int q = 0; q < edges.length; q++) {
                        edges[q] = list.get(q);
                    }

                    Node temporaryNode = new Node(name, index);
                    temporaryNode.setAdjacentNodes(edges);

                    graph.add(temporaryNode);

                }

                String paths = br.readLine();
                int numberOfPaths = Integer.parseInt(paths);

                for (int x = 0; x < numberOfPaths; x++) {
                    String current = br.readLine();
                    String[] values = current.split(" ");
                    String from = values[0];
                    String to = values[1];
                    distance.put(from, to);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static List<Node> getGraph() {
        return graph;
    }

    public static Map<String, String> getDistance() {
        return distance;
    }
}
