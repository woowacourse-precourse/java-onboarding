package onboarding;

import java.util.*;
import java.util.stream.Collectors;


/*
- 기능 구현사항 목록 -
1. email과 nickname을 가지는 class 생성
2. 2글자 단위로 잘라서
3. 중복된다면 set에 저장
 */
public class Problem6 {

    static Map<String, Integer> nickname = new HashMap<>();
    static Set<Integer> answer = new HashSet<>();

    static class User {
        private final String nick;
        private final String email;

        public String getEmail(){
            return email;
        }

        public User(String nick, String email){
            this.nick = nick;
            this.email = email;
        }
    }

    static void addAnswer(int idx) {
        answer.add(idx);
    }

    static void calc(String s, Integer idx) {
        for (int i = 0; i + 1 < s.length(); i++) {
            if (nickname.containsKey(s.substring(i, i + 2))) {
                if (!Objects.equals(nickname.get(s.substring(i, i + 2)), idx)) {
                    addAnswer(idx);
                    addAnswer(nickname.get(s.substring(i,i+2)));
                    answer.add(idx);
                    answer.add(nickname.get(s.substring(i, i + 2)));
                }
            } else {
                nickname.put(s.substring(i, i + 2), idx);
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        nickname.clear();
        answer.clear();

        List<User> ids = forms.stream().map(s -> new User(s.get(1), s.get(0))).collect(Collectors.toList());

        for (int i = 0; i < ids.size(); i++) {
            calc(ids.get(i).nick, i);
        }
        List<Integer> ans = new ArrayList<>(answer);
        Set<String> answer = new HashSet<>();
        ans.forEach((i) -> answer.add(ids.get(i).getEmail()));
        List<String> result = new ArrayList<>(answer);
        Collections.sort(result);
        return result;
    }


}