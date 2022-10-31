package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    //이름 속에서 중복될 수 있는 모든 단어를 저장한 Set을 반환하는 기능 구현
    public static Set<String> possibleDuplicatedWordInName(String name) {
        Set<String> duplicatedWord = new HashSet<>();

        for (int i = 0; i < name.length() - 1; i++) {
            duplicatedWord.add(name.substring(i, i + 2));
        }
        return duplicatedWord;
    }
}