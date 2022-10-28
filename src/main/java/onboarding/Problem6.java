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
        private String nick;
        private String email;

        public String getNick() {
            return nick;
        }

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


}