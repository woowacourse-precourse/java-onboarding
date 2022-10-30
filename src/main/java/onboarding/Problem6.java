package onboarding;

import java.util.*;

public class Problem6 {
    static HashMap<String, List<String>> map = new HashMap();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (List<String> one: forms) {
            answer.addAll(recordNick(one.get(1), one.get(0)));
        }
        Set<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }

    static List<String> recordNick(String nick, String email) {
        List<String> result = new ArrayList();
        String[] strArr = nick.split("");
        String twoCharOfNick;
        for (int i=0;i<strArr.length-1;i++) {
            twoCharOfNick = String.join("", Arrays.copyOfRange(strArr, i, i+2));
            if (map.containsKey(twoCharOfNick)) {
                if (map.get(twoCharOfNick).size() == 1) {
                    result.add(map.get(twoCharOfNick).get(0));
                }
                map.get(twoCharOfNick).add(email);
                result.add(email);
            } else {
                map.put(twoCharOfNick, new ArrayList<>(Arrays.asList(email)));
            }
        }
        return result;
    }
}
