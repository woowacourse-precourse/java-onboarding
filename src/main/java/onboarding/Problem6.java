package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> splitName = new HashMap<>();
        Set<String> checkDuplication = new HashSet<>();

        splitNickname(forms, splitName);

        for (String key : splitName.keySet()) {
            if (splitName.get(key).size() < 2) continue;
            checkDuplication.addAll(splitName.get(key));
        }

        answer.addAll(checkDuplication);
        Collections.sort(answer);

        return answer;
    }

    private static void splitNickname(List<List<String>> forms, Map<String, ArrayList<String>> splitName) {
        for (List<String> form : forms) {
            StringBuilder name = new StringBuilder(form.get(1));
            int length = name.length();
            String email = form.get(0);
            if (length == 1) {
                String temp = name.toString();
                saveSplitNicknameAndEmail(splitName, email, temp);
            } else {
                for (int i = 0; i < length - 1; i++) {
                    String temp = name.substring(i, i + 2);
                    saveSplitNicknameAndEmail(splitName, email, temp);
                }
            }
        }
    }

    private static void saveSplitNicknameAndEmail(Map<String, ArrayList<String>> splitName, String email, String temp) {
        if (splitName.containsKey(temp)) {
            splitName.get(temp).add(email);
        } else {
            splitName.put(temp, new ArrayList<>(List.of(email)));
        }
    }
}
