package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    static HashMap<String, List<String>> hashMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");
        return answer;
    }

    //닉네임을 두글자씩 나눈 것 기준으로 email과 함께 저장
    static void saveEmailByDivideNickName(String nickName, String email) {

        String key;

        for (int i = 0; i < nickName.length() - 1; i++) {
            key = nickName.substring(i, i + 2);

            if (hashMap.get(key) == null) {
                List<String> list = new ArrayList<>();
                list.add(email);
                hashMap.put(key, list);

            } else {
                hashMap.get(key).add(email);
            }
        }
    }


}
