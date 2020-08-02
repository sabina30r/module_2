package nix.edu;

import nix.edu.data.Edge;
import nix.edu.data.Node;
import java.util.List;
import java.util.PriorityQueue;

public class ThirdTaskUtil {

    public static void calculatePaths(List<Node> graph, Node source) {
        source.minDistance = 0.;
        PriorityQueue<Node> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Node node = vertexQueue.poll();


            for (Edge e : node.adjacentNodes) {
                int index = e.dest;
                Node currNode = getNodeByIndex(graph, index);
                double weight = e.weight;
                double distanceThroughU = node.minDistance + weight;
                if (distanceThroughU < currNode.minDistance) {
                    vertexQueue.remove(currNode);

                    currNode.minDistance = distanceThroughU;
                    currNode.previous = node;
                    vertexQueue.add(currNode);
                }
            }
        }
    }


    public static Node getNodeByIndex(List<Node> graph, int index) {
        Node result = null;
        for (Node node : graph) {
            if (node.index == index) {
                result = node;
            }
        }

        if (result == null) {
            throw new IllegalArgumentException("There is no node with such index.");
        }

        return result;
    }

    public static Node getNodeByName(List<Node> graph, String name) {
        Node result = null;
        for (Node node : graph) {
            if (node.name.equals(name)) {
                result = node;
            }
        }

        if (result == null) {
            throw new IllegalArgumentException("There is no node with such index.");
        }

        return result;
    }
}
