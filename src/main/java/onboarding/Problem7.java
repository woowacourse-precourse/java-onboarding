package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String,Integer> recommenedFreinds = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new LinkedList<>();
        calcVisitorsPoints(visitors);
        return answer;
    }

    private static void calcVisitorsPoints(List<String> visitors) {
        for (String visitor : visitors) {
            if(recommenedFreinds.containsKey(visitor)){
                recommenedFreinds.put(visitor, recommenedFreinds.get(visitor) + 1);
                continue;
            }
            recommenedFreinds.put(visitor, 1);
        }
    }
}
