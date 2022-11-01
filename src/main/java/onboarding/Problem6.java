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
        HashSet<String> email = new HashSet<>();

        for(int i = 0; i <forms.size(); i++) {
            email = checkNickname(forms.get(i), word_list);
            if(!email.isEmpty()) email_list.addAll(email);
        }
        answer = email_list.stream().sorted().collect(Collectors.toList());
        return answer;
    }
    public static HashSet<String> checkNickname(List<String> crew, HashMap<String, String> word_list) {
        String email = crew.get(0);
        String nickname = crew.get(1);
        HashSet<String> nicklist = new HashSet<>();

        for(int i = 0; i < nickname.length() -1; i++) {
            String find_nick =  nickname.substring(i, i+2);
            if(word_list.containsKey(find_nick)) {
                nicklist.add(email);
                nicklist.add(word_list.get(find_nick));
            }
            word_list.put(find_nick, email);
        }
        return nicklist;
    }
}
