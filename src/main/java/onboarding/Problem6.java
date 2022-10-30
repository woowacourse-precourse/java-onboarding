package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /*
    * Map의 Value 중 size가 2 이상인 Set의 이메일들을 List에 추가해 반환
    *
    * @return List<String>
    * */
    private static List<String> makeEmailList(Map<String, Set<String>> nicknameEmailMap) {
        List<String> emailList = new ArrayList<>();

        for (Set<String> emails : nicknameEmailMap.values()) {
            if (emails.size() >= 2) {
                emailList.addAll(emails);
            }
        }

        return emailList;
    }
}
