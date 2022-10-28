package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new java.util.ArrayList<>();


        for (int i = 0; i < forms.size(); i++) {
            List<String> currentUser = forms.get(i);
            for (int j = 0; j < forms.size(); j++) {
                List<String> compareUser = forms.get(j);
                if (!currentUser.equals(compareUser)) {
                    char[] currentUserSplit = currentUser.get(1).toCharArray();
                    char[] compareUserSplit = compareUser.get(1).toCharArray();
                    for (int charCount = 2; charCount < currentUserSplit.length; charCount++) {
                        for (int k = 0; k < currentUserSplit.length; k++) {
                                char isDuplicate[] = Arrays.copyOfRange(currentUserSplit, k, k + charCount);
                            if (new String(compareUserSplit).contains(new String(isDuplicate))) {
                                answer.add(currentUser.get(0));
                            }
                        }
                    }
                }
            }
            Collections.sort(answer);
            answer = answer.stream().distinct().collect(Collectors.toList());
        }

        return answer;
    }
}
