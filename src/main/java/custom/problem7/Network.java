package custom.problem7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {

    private final Map<String, List<String>> graph;

    public Network(List<List<String>> input) {
        Validator.validateSize(input);
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> elemList : input) {
            String a = elemList.get(0);
            String b = elemList.get(1);
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        this.graph = Collections.unmodifiableMap(map);
    }

    public List<String> getAdj(String node) {
        return graph.getOrDefault(node, new ArrayList<>());
    }


    static class Validator {

        static void validateSize(List<List<String>> input) {
            if (!(input.size() > 1 && input.get(0).size() == 2)) {
                throw new RuntimeException("input은 존재해야하고 내부 리스트 크기는 2여야 합니다");
            }
        }
    }
}
