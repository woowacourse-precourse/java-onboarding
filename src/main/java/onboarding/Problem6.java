package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> originAccount : forms) {
            for (List<String> targetAccount : forms) {
                if(originAccount.equals(targetAccount)){
                    continue;
                }
                if (isDupedNameExist(originAccount.get(1), targetAccount.get(1))) {
                    if (!answer.contains(targetAccount.get(0))) {
                        answer.add(targetAccount.get(0));
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static boolean isDupedNameExist(String origin, String target) {
        for (int i = 0; i < target.length() - 1; i++) {
            for (int j = 0; j < origin.length() - 1; j++) {
                if(origin.charAt(j)==target.charAt(i)&&origin.charAt(j+1)==target.charAt(i+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
