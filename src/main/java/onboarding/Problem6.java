package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {

    public static List<String> splitNickName(String nickname) {
        List<String> nicknameSet = new ArrayList<String>();
        for(int i = 0; i < nickname.length()-1; i++) {
            String nicknameElement = "";
            nicknameElement += nickname.charAt(i);
            nicknameElement += nickname.charAt(i+1);
            nicknameSet.add(nicknameElement);
        }
        return nicknameSet;
    }

    public static boolean compareElement (List<String> nicknameSet, String nickname) {
        for (String nicknameElement: nicknameSet) {
            if (nickname.contains(nicknameElement)) return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}