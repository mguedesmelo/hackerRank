package com.hackerRank.oneMonth.week.four;
import java.util.ArrayList;
import java.util.List;

public class RoadsAndLibraries {
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    	// If the cost of building a library is less than or equal to the cost of building a road,
    	// it is more cost-effective to build a library in each city.
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> road : cities) {
            int city1 = road.get(0);
            int city2 = road.get(1);
            graph.get(city1).add(city2);
            graph.get(city2).add(city1);
        }

        boolean[] visited = new boolean[n + 1];
        long totalCostToReturn = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                long componentSize = dfs(i, graph, visited);
                totalCostToReturn += c_lib + (componentSize - 1) * c_road;
            }
        }

        return totalCostToReturn;
    }

    private static long dfs(int city, List<List<Integer>> graph, boolean[] visited) {
        visited[city] = true;
        long componentSize = 1;
        for (int neighbor : graph.get(city)) {
            if (!visited[neighbor]) {
                componentSize += dfs(neighbor, graph, visited);
            }
        }
        return componentSize;
    }

    public static void main(String[] args) {
        // Example usage:
        int n = 3;
        int c_lib = 2;
        int c_road = 1;
        List<List<Integer>> cities = List.of(
                List.of(1, 2),
                List.of(3, 1),
                List.of(2, 3)
        );

        long result = roadsAndLibraries(n, c_lib, c_road, cities);
        System.out.println("Minimum cost: " + result);
    }
}
