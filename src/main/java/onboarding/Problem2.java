package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        String s = cryptogram;
        List<Object> list = new ArrayList<>();
        int count = 1;
        String[] strArray = s.split("");
        for (String split : strArray) {
            list.add(split);
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).equals(list.get(j + 1))) {
                    list.remove(j + 1);
                    list.remove(j);
                }
                count++;
            }
        }

            StringBuilder sb = new StringBuilder();
            for (Object item : list) {
                sb.append(item);
            }
            answer = sb.toString();
        return answer;
    }
}





