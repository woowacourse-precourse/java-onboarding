package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 기능 사항
 * a. nickname과 email을 포함한 User Class 구현
 * b. 중복된 이름일 경우 set에 저장
 * c. 두 자씩 map에 저장
 */
public class Problem6 {

    static Map<String, Integer> nickname = new HashMap<>();
    static Set<Integer> answer = new HashSet<>();
    /**
     * a. User Class
     */
    static class User {

        private String nickname;
        private String email;

        public String getEmail() {
            return email;
        }

        public User(String nickname, String email) {
            this.nickname = nickname;
            this.email = email;

        }
    }


    /**
     * b. 중복된 이름일 경우 set에 저장
     * idx를 answer set에 저장
     */
    static void addAnswer(int idx){
        answer.add(idx);

    }

    /**
     * c. 두 자씩 map에 저장
     * @param s 유저의 닉네임
     * @param idx 해당 유저의 인덱스
     */
    static void cal(String s, Integer idx) {
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
            cal(ids.get(i).nickname, i);
        }
        List<Integer> ans = new ArrayList<>(answer);
        Set<String> answer = new HashSet<>();
        ans.forEach((i) -> answer.add(ids.get(i).getEmail()));
        List<String> result = new ArrayList<>(answer);
        Collections.sort(result);
        return result;
    }
}