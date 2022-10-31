package onboarding;

import java.util.HashMap;
import java.util.Map;

class TreeFrog {
    /**
     * 개구리마다 각자의 번역 사전이 있을 수 있다.
     * 따라서, 인스턴스를 생성해서 매소드를 호출하는 것이 좋다.
     */

    private Map<Character, Character> lowerCaseDictionary = new HashMap<>();
    private Map<Character, Character> upperCaseDictionary = new HashMap<>();

    public TreeFrog() { // frog 자체의 사전을 정의
        for (int i = 0; i < 26; i++) {
            lowerCaseDictionary.put((char) ('a' + i), (char) ('z' - i));
            upperCaseDictionary.put((char) ('A' + i), (char) ('Z' - i));
        }
    }

    public String frogTranslation(String word) {
        StringBuilder answer = new StringBuilder("");   // 수정이 잦은 문자열이기 때문에 StringBuilder class를 사용함

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int caseFlag = checkCase(c);

            switch (caseFlag) {
                case 0:
                    answer.append(lowerCaseDictionary.get(c));
                    break;
                case 1:
                    answer.append(upperCaseDictionary.get(c));
                    break;
                case -1:
                    answer.append(c);
                    break;
            }
        }

        return answer.toString();
    }

    public int checkCase(char character) {
        if (character >= 'a' && character <= 'z') {
            return 0;
        } else if (character >= 'A' && character <= 'Z') {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Problem4 {
    public static String solution(String word) {
        String answer;

        TreeFrog treeFrog = new TreeFrog();

        answer = treeFrog.frogTranslation(word);

        return answer;
    }
}
