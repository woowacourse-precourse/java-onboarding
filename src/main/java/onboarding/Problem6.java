package onboarding;

import java.util.*;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    static final int LIMIT_DUPLICATED = 2;
    static final int SEPARATE_COUNT = 2;

    static HashMap<String, Integer> twoLetterCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> separatedCrewNicknameList = getSeparatedCrewNicknameList(forms);
        countListToMap(separatedCrewNicknameList);
        List<String> crewEmailListOfDuplicatedNickname = getCrewEmailListOfDuplicatedNickname(separatedCrewNicknameList, forms);
        Collections.sort(crewEmailListOfDuplicatedNickname);
        return crewEmailListOfDuplicatedNickname;
    }

    private static List<String> getCrewEmailListOfDuplicatedNickname(List<List<String>> separatedCrewNicknameList, List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < separatedCrewNicknameList.size(); i++) {
            int countOfSeparatedNickname = getMaxCountOfSeparatedNickname(separatedCrewNicknameList.get(i));
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


    private static void countListToMap(List<List<String>> separatedCrewNicknameList) {
        for (List<String> crewSeparatedNickname : separatedCrewNicknameList) {
            putListToMap(crewSeparatedNickname);
        }
    }

    private static void putListToMap(List<String> crewSeparatedNickname) {
        for (String twoLetters : crewSeparatedNickname) {
            twoLetterCountMap.put(twoLetters, twoLetterCountMap.getOrDefault(twoLetters, 0) + 1);
        }
    }

    private static List<List<String>> getSeparatedCrewNicknameList(List<List<String>> forms) {
        List<List<String>> separatedCrewNicknameList = new ArrayList<>();
        for (List<String> crew : forms) {
            List<String> temp = new ArrayList<>(getSeparatedNicknameToList(crew.get(NICKNAME)));
            separatedCrewNicknameList.add(temp);
        }
        return separatedCrewNicknameList;
    }

    private static List<String> getSeparatedNicknameToList(String nickname) {
        List<String> separatedNickname = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetters = nickname.substring(i, i + SEPARATE_COUNT);
            separatedNickname.add(twoLetters);
        }
        return separatedNickname;
    }
}
