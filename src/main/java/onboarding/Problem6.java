package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 기능 사항
 * 1. nickname과 email을 포함한 User Class 구현
 * 2. 중복된 이름일 경우 set에 저장하는 함수
 * 3. 두 자씩 map에 저장하는 함수
 */
public class Problem6 {



    static Map<String, Integer> nicknameMap = new HashMap<>();
    static Set<Integer> answerSet = new HashSet<>();
    /**
     * 1. User Class 구현
     */
    static class User {

        private String nickname;
        private String email;

        public String getNickname() {
            return nickname;
        }


        public String getEmail() {
            return email;
        }

        public User(String nickname, String email) {
            this.nickname = nickname;
            this.email = email;

        }
    }


    /**
     * 2. 중복된 이름일 경우 set에 저장하는 함수
     * idx 를 answer set에 저장하는 함수
     */
    static void addAnswer(int idx){
        answerSet.add(idx);

    }

    /**
     * 3. 두 자씩 map에 저장하는 함수
     * @param s 유저의 닉네임
     * @param idx 해당 유저의 인덱스
     */
    static void calc(String s, Integer idx) {
        for (int i = 0; i + 1 < s.length(); i++) {
            if (nicknameMap.containsKey(s.substring(i, i + 2))) {
                if (!Objects.equals(nicknameMap.get(s.substring(i, i + 2)), idx)) {
                    addAnswer(idx);
                    addAnswer(nicknameMap.get(s.substring(i,i+2)));
                    answerSet.add(idx);
                    answerSet.add(nicknameMap.get(s.substring(i, i + 2)));
                }
            } else {
                nicknameMap.put(s.substring(i, i + 2), idx);
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        nicknameMap.clear();
        answerSet.clear();

        List<User> ids = forms.stream().map(s -> new User(s.get(1), s.get(0))).collect(Collectors.toList());

        for (int i = 0; i < ids.size(); i++) {
            calc(ids.get(i).nickname, i);
        }
        List<Integer> ans = new ArrayList<>(answerSet);
        Set<String> answer = new HashSet<>();
        ans.forEach((i) -> answer.add(ids.get(i).getEmail()));
        List<String> result = new ArrayList<>(answer);
        Collections.sort(result);
        return result;
    }
}
