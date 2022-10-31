package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> word_list = new HashMap<>();
        HashSet<String> email_list = new HashSet<>();
//
        for(List<String> crew : forms) {
            email_list.addAll(checkNickname(crew, word_list));
        }
        answer = email_list.stream().sorted().collect(Collectors.toList());
        return answer;
    }
    public static HashSet<String> checkNickname(List<String> crew, HashMap<String, String> word_list) {
        String email = crew.get(0);
        String nickname = crew.get(1);
        HashSet<String> nicklist = new HashSet<>();

        if(word_list.isEmpty()) nicklist = null;
        for(int i = 0; i < nickname.length() -1; i++) {
            String find_nick =  nickname.substring(i, i+2);
            if(word_list.containsValue(find_nick)) nicklist.add(word_list.get(find_nick));
            word_list.put(find_nick, email);
        }
        return nicklist;
    }
}
