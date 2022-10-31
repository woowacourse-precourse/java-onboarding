package onboarding;

import java.util.*;

public class Problem6 {
    public static HashMap<String, String> duplicatedWord_EmailHashMap = new HashMap<>();
    public static HashSet<String> answerEmailSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> emailNameList : forms) {
            Set<String> duplicatedWord = possibleDuplicatedWordInName(emailNameList.get(1));
            checkDuplicate(duplicatedWord, emailNameList);
        }
        List<String> answer = new ArrayList<>(answerEmailSet);
        Collections.sort(answer);
        return answer;
    }

    //중복 가능성이 있는 단어들을 포함하는지 확인하는 기능 구현.
    //그다음 isContain을 notContains, contains의 인자로 넘겨준다.
    public static void checkDuplicate(Set<String> duplicatedWord, List<String> emailNameList) {
        for (String word : duplicatedWord) {
            boolean isContain = duplicatedWord_EmailHashMap.containsKey(word);
            notContains(isContain, word, emailNameList);
            contains(isContain, word, emailNameList);
        }
    }

    //닉네임이 중복 가능성이 있는 단어를 포함하지 않는 경우 작동하는 함수
    public static void notContains(boolean isContain, String word, List<String> emailNameList) {
        if (!isContain) {
            duplicatedWord_EmailHashMap.put(word, emailNameList.get(0));
        }
    }

    //닉네임이 중복 가능성이 있는 단어를 포함하는 않는 경우 작동하는 함수
    public static void contains(boolean isContain, String word, List<String> emailNameList) {
        if (isContain) {
            answerEmailSet.add(emailNameList.get(0));
            answerEmailSet.add(duplicatedWord_EmailHashMap.get(word));
        }
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