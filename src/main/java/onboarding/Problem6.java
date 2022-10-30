package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    static final int LIMIT_DUPLICATED = 2;
    static HashMap<String, Integer> twoLetterCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> separatedNickname = new ArrayList<>();
        addSeperatedNicknameToList(forms, separatedNickname);
        countTwoLettersToMap(separatedNickname);
        List<String> emailListOfDuplicatedNickname = getEmailListOfDuplicatedNickname(separatedNickname, forms);
        return new ArrayList<>();
    }

    private static List<String> getEmailListOfDuplicatedNickname(List<List<String>> separatedNickname, List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < separatedNickname.size(); i++) {
            int countOfSeparatedNickname = getMaxCountOfSeparatedNickname(separatedNickname.get(i));
            if (countOfSeparatedNickname >= LIMIT_DUPLICATED) {
                emailList.add(getEmail(forms.get(i)));
            }
        }
        return emailList;
    }

    private static String getEmail(List<String> crew) {
        return crew.get(EMAIL);
    }

    private static int getMaxCountOfSeparatedNickname(List<String> separatedNickname) {
        int count = -1;
        for (String twoLetters : separatedNickname) {
            count = Math.max(twoLetterCountMap.get(twoLetters), count);
        }
        return count;
    }


    private static void countTwoLettersToMap(List<List<String>> separatedNickname) {
        for (List<String> crewSeparatedNickname : separatedNickname) {
            putListToMap(crewSeparatedNickname);
        }
    }

    private static void putListToMap(List<String> crewSeparatedNickname) {
        for (String twoLetters : crewSeparatedNickname) {
            twoLetterCountMap.put(twoLetters, twoLetterCountMap.getOrDefault(twoLetters, 0) + 1);
        }
    }

    private static void addSeperatedNicknameToList(List<List<String>> forms, List<List<String>> separatedNickname) {
        for (List<String> crew : forms) {
            List<String> temp = new ArrayList<>(getSeparatedTwoConsecutiveLetters(crew.get(NICKNAME)));
            separatedNickname.add(temp);
        }
    }

    private static List<String> getSeparatedTwoConsecutiveLetters(String nickname) {
        List<String> separatedNickname = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetters = nickname.substring(i, i + 2);
            separatedNickname.add(twoLetters);
        }
        return separatedNickname;
    }
}
