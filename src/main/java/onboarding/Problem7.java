package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Map<String, List<String>>toMap(List<List<String>> linkedNodes){
        Map<String, List<String>> linkedMap = new HashMap<>();

        for (List<String> linkedNode: linkedNodes){
            String nodeA =  linkedNode.get(0);
            String nodeB =  linkedNode.get(1);

            List<String> nodesLinkedToA= linkedMap.getOrDefault(
                    nodeA, new ArrayList<>());
            List<String> nodesLinkedToB = linkedMap.getOrDefault(
                    nodeB, new ArrayList<>());

            nodesLinkedToA.add(nodeB);
            nodesLinkedToB.add(nodeA);

            linkedMap.put(nodeA, nodesLinkedToA);
            linkedMap.put(nodeB, nodesLinkedToB);
        }

        return linkedMap;
    }
}
