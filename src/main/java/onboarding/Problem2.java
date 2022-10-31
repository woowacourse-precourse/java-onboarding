package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> characterList = new ArrayList<>();
        boolean flag = false;

        initList(cryptogram, characterList);
        flag = isAnyRemovable(characterList);
        deduplicate(characterList, flag);

        answer = charListToString(characterList);

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

    private static String charListToString(List<Character> characterList) {
        String str;
        str = characterList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return str;
    }
}
