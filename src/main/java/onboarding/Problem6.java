package onboarding;

import java.util.*;
import java.util.Collections;

public class Problem6 {

    static List<String> answer = new ArrayList<String>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean similarNameCheck(String name1, String name2) {
        boolean check = false;

        for (int k = 0; k < name1.length() - 1; k++) {
            if (name2.contains(name1.substring(k, k + 2))) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static void emailAddressInput(Set<Integer> printListNumberSet, List<List<String>> originForms) {
        Iterator<Integer> it = printListNumberSet.iterator();

        while (it.hasNext())
            answer.add(originForms.get((int)it.next()).get(0));

        Collections.sort(answer);
    }


}
