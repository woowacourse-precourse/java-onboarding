package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> word_list = new HashMap<>();
        HashSet<String> email_list = new HashSet<>();
//        for (List<String> crew : forms) {
//            crew_list.put(crew.get(0), crew.get(1));
//        }
        List<String> email;
        for(List<String> crew : forms) {
            email = checkNickname(crew, word_list);
            if(email != null) {
                //중복임. 이메일 목록에 추가
                email_list.add()
            }
            // 중복 확인 끝난 crew
            word_list.put(crew.get(0), crew.get(1));
        }
        return answer;
    }
    public static List<String> checkNickname(List<String> crew, HashMap<String, String> word_list) {
        String email = crew.get(0);
        String nickname = crew.get(1);
        List<String> nicklist = new ArrayList<>();
        if(word_list.isEmpty()) nicklist = null;
        for(int i = 0; i < nickname.length() -1; i++) {
            String find_nick =  nickname.substring(i, i+2);
            if(word_list.containsValue(find_nick)) nicklist.add(word_list.get(find_nick));
            word_list.put(find_nick, email);
        }
        return nicklist;
    }
}
