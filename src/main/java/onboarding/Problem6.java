package onboarding;

import java.util.*;

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
     * idx1, idx2를 answer set에 저장하는 함수
     */
    static void addAnswer(int idx1, int idx2){
        answerSet.add(idx1);
        answerSet.add(idx2);

    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
