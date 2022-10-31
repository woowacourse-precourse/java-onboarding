package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> crew_list = new HashMap<>();
        HashSet<String> email_list = new HashSet<>();
//        for (List<String> crew : forms) {
//            crew_list.put(crew.get(0), crew.get(1));
//        }
        List<String> email;
        for(List<String> crew : forms) {
            email = checkNickname(crew.get(1), crew_list);
            if(email != null) {
                //중복임. 이메일 목록에 추가
            }
            // 중복 확인 끝난 crew
            crew_list.put(crew.get(0), crew.get(1));
        }
        return answer;
    }
    public static List<String> checkNickname(String Nickname, HashMap<String, String> crew_list) {
        if(crew_list.isEmpty()) return null;
        List<String> nicklist = new ArrayList<>();
        for(int i = 0; i < Nickname.length(); i++) {
            String find_nick = Nickname.substring(i, i+2);
            if(crew_list.containsValue(find_nick)) nicklist.add(crew_list.get(find_nick));
        }
        return nicklist;
    }
}
