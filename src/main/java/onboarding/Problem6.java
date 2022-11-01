package onboarding;

import javax.swing.*;
import java.util.*;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    private static void selectCrew(List<List<String>> forms, HashMap<String, String> nicknameEmailMap, HashSet<String> duplicateCrewEmailList) {
        for (int i = 0; i < forms.size(); i++) {
            String crewNickname = forms.get(i).get(NICKNAME);
            String email = forms.get(i).get(EMAIL);
            makeWordOfNickname(nicknameEmailMap, duplicateCrewEmailList, crewNickname, email);
        }
    }

    private static void makeWordOfNickname(HashMap<String, String> nicknameEmailMap, HashSet<String> duplicateCrewEmailList, String nickname, String email) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            char firstCharacter = nickname.charAt(i);
            char secondCharacter = nickname.charAt(i + 1);
            String wordOfNickname = String.valueOf(firstCharacter) + String.valueOf(secondCharacter);
            checkDuplicate(nicknameEmailMap, duplicateCrewEmailList, wordOfNickname, email);
        }
    }

    private static void checkDuplicate(HashMap<String, String> nicknameEmailMap, HashSet<String> duplicateCrewEmailList, String wordOfNickname, String email){
        if(!nicknameEmailMap.containsKey(wordOfNickname)){
            nicknameEmailMap.put(wordOfNickname, email);
            return;
        }
        duplicateCrewEmailList.add(nicknameEmailMap.get(wordOfNickname));
        duplicateCrewEmailList.add(email);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> result = new ArrayList<>();
        HashMap<String, String> nicknameEmailMap = new HashMap<>();
        HashSet<String> duplicateCrewEmailList = new HashSet<>();

        selectCrew(forms, nicknameEmailMap, duplicateCrewEmailList);

//        duplicateCrewEmailList.stream().sorted().forEach(email -> result.add(email));

        answer = result;

        return answer;
    }
}

