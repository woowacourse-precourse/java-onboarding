package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem6 {

    private static List<String> emailListAddEmail (List<String> emailList, String email) {
        if (emailList == null)
            emailList = new LinkedList<>();
        emailList.add(email);
        return emailList;
    }

    private static String returnNicknameOrEmail (List<String> userInfo, int data) {
        return userInfo.get(data);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}