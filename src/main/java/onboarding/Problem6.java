package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> splitName = new HashMap<>();

        for (List<String> form : forms) {
            StringBuilder sb = new StringBuilder(form.get(1));
            int length = sb.length();
            for (int i = 0 ; i < length-1; i++){
                for (int j = i + 1; j < length; j++){
                    String temp = sb.substring(i, j + 1);
                    if (splitName.containsKey(temp)) {
                        splitName.get(temp).add(form.get(0));
                    }else {
                        splitName.put(temp, new ArrayList<>(Arrays.asList(form.get(0))));
                    }
                }
            }
        }

        Set<String> checkDuplication = new HashSet<>();

        for (String key : splitName.keySet()) {
            if (splitName.get(key).size() < 2) continue;
            for (String email : splitName.get(key)) {
                checkDuplication.add(email);
            }
        }

        answer.addAll(checkDuplication);
        Collections.sort(answer);
        return answer;
    }
}
