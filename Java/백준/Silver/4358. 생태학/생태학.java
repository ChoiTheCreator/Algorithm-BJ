import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int totalTrees = 0;

        String tree;
        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            totalTrees++;
        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String name = entry.getKey();
            double percentage = (entry.getValue() * 100.0) / totalTrees;
            System.out.printf("%s %.4f%n", name, percentage);
        }
    }
}