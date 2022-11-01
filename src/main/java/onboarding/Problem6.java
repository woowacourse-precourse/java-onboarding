package onboarding;

import java.util.*;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    static final int LIMIT_DUPLICATED = 2;
    static final int SEPARATE_COUNT = 2;

    static HashMap<String, Integer> twoLetterCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> separatedAllCrewNicknameList = getSeparatedAllCrewNicknameList(forms);
        countListToMap(separatedAllCrewNicknameList);
        List<String> crewEmailListOfDuplicatedNickname = getCrewEmailListOfDuplicatedNickname(separatedAllCrewNicknameList, forms);
        Collections.sort(crewEmailListOfDuplicatedNickname);
        return crewEmailListOfDuplicatedNickname;
    }

    private static List<String> getCrewEmailListOfDuplicatedNickname(List<List<String>> separatedAllCrewNicknameList, List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < separatedAllCrewNicknameList.size(); i++) {
            int countOfSeparatedNickname = getMaxCountOfSeparatedNickname(separatedAllCrewNicknameList.get(i));
            if (countOfSeparatedNickname >= LIMIT_DUPLICATED) {
                emailList.add(getEmail(forms.get(i)));
            }
        }
        return emailList;
    }

    private static String getEmail(List<String> crew) {
        return crew.get(EMAIL);
    }

    private static int getMaxCountOfSeparatedNickname(List<String> separatedCrewNickname) {
        int count = -1;
        for (String twoLetters : separatedCrewNickname) {
            count = Math.max(twoLetterCountMap.get(twoLetters), count);
        }
        return count;
    }


    private static void countListToMap(List<List<String>> separatedAllCrewNicknameList) {
        for (List<String> separatedCrewNickname : separatedAllCrewNicknameList) {
            putListToMap(separatedCrewNickname);
        }
    }

    private static void putListToMap(List<String> separatedCrewNickname) {
        for (String twoLetters : separatedCrewNickname) {
            twoLetterCountMap.put(twoLetters, twoLetterCountMap.getOrDefault(twoLetters, 0) + 1);
        }
    }

    private static List<List<String>> getSeparatedAllCrewNicknameList(List<List<String>> forms) {
        List<List<String>> separatedAllCrewNicknameList = new ArrayList<>();
        for (List<String> crew : forms) {
            List<String> temp = new ArrayList<>(getSeparatedCrewNicknameList(crew.get(NICKNAME)));
            separatedAllCrewNicknameList.add(temp);
        }
        return separatedAllCrewNicknameList;
    }

    private static List<String> getSeparatedCrewNicknameList(String nickname) {
        List<String> separatedCrewNickname = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetters = nickname.substring(i, i + SEPARATE_COUNT);
            separatedCrewNickname.add(twoLetters);
        }
        return separatedCrewNickname;
    }
}
