package onboarding;

import java.util.*;

public class Problem6 {
    static List<String> nicknameList = new ArrayList<>();
    static List<String> nicknameSubset = new ArrayList<>();
    static HashMap<String, Integer> nicknameSubsetNumber = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void setNicknameList(List<List<String>> forms) {
        for (Iterator<List<String>> iter = forms.iterator(); iter.hasNext(); ) {
            nicknameList.add(iter.next().get(1));
        }
    }

    public static void removeOneLetterNickname() {
        for (String nickname : nicknameList) {
            if (nickname.length() == 1) {
                nicknameList.remove(nickname);
            }
        }
    }

    public static void addNicknameSubset() {
        for (String nickname : nicknameList) {
            cutNickname(nickname);
        }
    }

    public static void cutNickname(String nickname) {
        for (int i = 0; i <= nickname.length() - 2; i++) {
            nicknameSubset.add(nickname.substring(i, i + 2));
        }
    }

    public static void resetSubsetNumber() {
        for (String subset : nicknameSubset) {
            nicknameSubsetNumber.put(subset, 0);
        }
    }

    public static void countDuplicateSubset() {
        for (String subset : nicknameSubset) {
            nicknameSubsetNumber.put(subset, nicknameSubsetNumber.get(subset) + 1);
        }
    }

    public static void isDuplicatedSubset() {
        for (Map.Entry<String, Integer> entry : nicknameSubsetNumber.entrySet()) {
            String subset = entry.getKey();
            int duplicatedNum = entry.getValue();

            if (duplicatedNum >= 2) {
                nicknameSubset.add(subset);
            }
        }
    }
}