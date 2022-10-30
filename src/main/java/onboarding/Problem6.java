package onboarding;

import java.util.*;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    static final int LIMIT_DUPLICATED = 2;
    static HashMap<String, Integer> twoLetterCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> separatedEachCrewNicknameList = getSeperatedEachCrewNicknameList(forms);
        countListToMap(separatedEachCrewNicknameList);
        List<String> crewEmailListOfDuplicatedNickname = getCrewEmailListOfDuplicatedNickname(separatedEachCrewNicknameList, forms);
        Collections.sort(crewEmailListOfDuplicatedNickname);
        return new ArrayList<>();
    }

    private static List<String> getCrewEmailListOfDuplicatedNickname(List<List<String>> separatedEachCrewNicknameList, List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < separatedEachCrewNicknameList.size(); i++) {
            int countOfSeparatedNickname = getMaxCountOfSeparatedNickname(separatedEachCrewNicknameList.get(i));
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


    private static void countListToMap(List<List<String>> separatedEachCrewNicknameList) {
        for (List<String> crewSeparatedNickname : separatedEachCrewNicknameList) {
            putListToMap(crewSeparatedNickname);
        }
    }

    private static void putListToMap(List<String> crewSeparatedNickname) {
        for (String twoLetters : crewSeparatedNickname) {
            twoLetterCountMap.put(twoLetters, twoLetterCountMap.getOrDefault(twoLetters, 0) + 1);
        }
    }

    private static List<List<String>> getSeperatedEachCrewNicknameList(List<List<String>> forms) {
        List<List<String>> separatedEachCrewNicknameList = new ArrayList<>();
        for (List<String> crew : forms) {
            List<String> temp = new ArrayList<>(getSeparatedNicknameToList(crew.get(NICKNAME)));
            separatedEachCrewNicknameList.add(temp);
        }
        return separatedEachCrewNicknameList;
    }

    private static List<String> getSeparatedNicknameToList(String nickname) {
        List<String> separatedNickname = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetters = nickname.substring(i, i + 2);
            separatedNickname.add(twoLetters);
        }
        return separatedNickname;
    }
}
