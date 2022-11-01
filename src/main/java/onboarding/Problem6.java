package onboarding;

import java.util.*;
import java.util.Collections;

public class Problem6 {

    static List<String> answer = new ArrayList<String>();
    public static List<String> solution(List<List<String>> forms) {

        Set<Integer> printListSet = new HashSet<Integer>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (similarNameCheck(forms.get(i).get(1), forms.get(j).get(1))) {
                    printListSet.add(i);
                    printListSet.add(j);
                }

            }
        }

        emailAddressInput(printListSet, forms);

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
