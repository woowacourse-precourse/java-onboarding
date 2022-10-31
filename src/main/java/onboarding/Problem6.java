package onboarding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem6 {
    static List<String> nicknameList = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void setNicknameList(List<List<String>> forms) {
        for (Iterator<List<String>> iter = forms.iterator(); iter.hasNext(); ) {
            nicknameList.add(iter.next().get(1));
        }
    }

    public static void removeOneLetterNickname() {
        for (String nickname : nicknameList) {
            if (nickname.length() == 1) {
                nicknameList.remove(nickname);
            }
        }
    }
}