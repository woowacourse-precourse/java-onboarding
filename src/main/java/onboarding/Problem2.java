package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static void initList(String cryptogram, List<Character> characterList) {
        for (char ch : cryptogram.toCharArray()) {
            characterList.add(ch);
        }
    }

    private static boolean isAnyRemovable(List<Character> characterList) {
        for (int i = 0; i < characterList.size()-1; i++) {
            if (characterList.get(i) == characterList.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static void deduplicate(List<Character> characterList, boolean flag) {
        while (flag) {
            for (int i = 0; i < characterList.size()-1; i++) {
                if (characterList.get(i) == characterList.get(i + 1)) {
                    int count = 0;
                    for (int j = i; j < characterList.size(); j++) {
                        if (characterList.get(j) != characterList.get(i)) {
                            break;
                        }
                        count++;
                    }
                    for (int j = 0; j < count; j++) {
                        characterList.remove(i);
                    }
                    i--;
                }
            }
            flag = isAnyRemovable(characterList);
        }
    }

    private String charListToString(List<Character> characterList) {
        return null;
    }
}
