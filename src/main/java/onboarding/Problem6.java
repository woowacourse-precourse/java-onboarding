package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<String>();
        HashMap<String,String> map = new HashMap<>();

        for(List<String> i : forms){
            String s = i.get(1);
            String sub = null;

            for(int j=0;j<s.length()-1;j++) {
                sub = s.substring(j, j + 2);

                if (!map.containsKey(sub)) {
                    map.put(sub, i.get(0));
                } else {
                    answer.add(map.get(sub));
                    answer.add(i.get(0));
                }
            }
        }

        List<String> newList =new ArrayList<String>(answer);
        Collections.sort(newList);

        return newList;
    }
}
