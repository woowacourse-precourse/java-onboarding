package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> emailToNotify = new ArrayList<>();

        for (int i = 0 ; i < forms.size() - 1 ; i++) {
            for (int j = i + 1 ; j < forms.size() ; j++) {
                if (duplicateChecker(forms.get(i).get(1), forms.get(j).get(1))) {
                    emailToNotify.add(forms.get(i).get(0));
                    emailToNotify.add(forms.get(j).get(0));
                }
            }
        }

        Set<String> set = new HashSet<String>(emailToNotify);
        List<String> answer = new ArrayList<String>(set);

        Collections.sort(answer);
        return answer;
    }

    private static boolean duplicateChecker(String string1, String string2) {
        for(int i = 0; i < string1.length() - 1; i++) {
            if (string2.contains(string1.substring(i, i + 2))) { //substring 잘못 이해해서 삽질함
                return true;
            }
        }
        return false;
    }
}
