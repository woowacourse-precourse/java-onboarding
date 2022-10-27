package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> userTwoLetterList = new HashMap<>();
        List<String> answer = List.of("answer");
        for (List<String> form : forms) {
            makeUserTwoLetterList(form.get(1), userTwoLetterList);
        }

        return answer;
    }

    public static void makeUserTwoLetterList(String nickName, HashMap<String, Integer> userTwoLetterList) {
        String[] splitNickName = nickName.split("");
        for (int i = 0; i < splitNickName.length-1; i++) {
            String userTwoLetter = splitNickName[i]+splitNickName[i+1];
            userTwoLetterList.put(userTwoLetter, userTwoLetterList.getOrDefault(userTwoLetter, 0) + 1);
        }
    }
}
