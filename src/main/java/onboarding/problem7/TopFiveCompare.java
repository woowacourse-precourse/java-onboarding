package onboarding.problem7;

import org.junit.jupiter.api.Order;

import java.util.*;

public class TopFiveCompare {

    public List<String> sortOrder(HashMap<String, Integer> scoreMap) {

        List<String> five = new ArrayList<>();
        List<HashMap.Entry<String, Integer>> scoreList =
                        new LinkedList<>(scoreMap.entrySet());

        scoreList.sort(new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int current = o2.getValue().compareTo(o1.getValue());

                if (current == 0) {
                    current = o1.getKey().compareTo(o2.getKey());
                }
                return current;
            }
        });

        topFive(five, scoreList);

        return five;
    }




}
