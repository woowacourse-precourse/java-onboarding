package onboarding;

import java.util.*;

public class Problem6 {
    private static HashMap<String, List<String>> twoLetters = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        initTwoLetters();

        for (List<String> userInfo : forms) {
            int checkIndex = userInfo.get(1).length() - 1;
            checkDuplicateLetters(checkIndex, userInfo);
        }

        answer = extractEmailsByDuplicateNickname();
        answer = removeDuplicateEmailData(answer);
        Collections.sort(answer);

        return answer;
    }

    private static void initTwoLetters() {
        twoLetters = new HashMap<>();
    }

    private static void checkDuplicateLetters(int checkIndex, List<String> userInfo) {
        for (int i = 0; i < checkIndex; i++) {
            String checkTwoLetter = userInfo.get(1).substring(i, i + 2);
            List<String> tempList = new ArrayList<>();
            if (isContainTwoLetter(checkTwoLetter)) {
                tempList = twoLetters.get(checkTwoLetter);
            }

            tempList.add(userInfo.get(0));
            twoLetters.put(checkTwoLetter, tempList);
        }
    }

    private static boolean isContainTwoLetter(String checkTwoLetter) {
        return twoLetters.containsKey(checkTwoLetter);
    }

    private static List<String> extractEmailsByDuplicateNickname() {
        List<String> answer = new ArrayList<>();

        for (String key : twoLetters.keySet()) {
            if (twoLetters.get(key).size() > 1) {
                Collections.addAll(answer, twoLetters.get(key).toArray(new String[0]));
            }
        }

        return answer;
    }

    private static List<String> removeDuplicateEmailData(List<String> answer) {
        HashSet<String> tempSet = new HashSet<>(answer);
        answer = new ArrayList<>(tempSet);
        return answer;
    }
}
