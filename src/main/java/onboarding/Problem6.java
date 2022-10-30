package onboarding;

import java.util.*;

/**
 *  구현할 기능 목록
 *      1. User 클래스 구현
 *          1.1. 닉네임과 이메일 프로퍼티를 가진다.
 *
 *      2. 크루들의 닉네임 중 같은 글자가 연속적으로 포함될 경우 해당 닉네임 사용 제한하는 기능
 *          2.1. 닉네임을 2글자씩 Set저장한다.
 *          2.2. Map을 통해 {key:value} -> {토큰, 닉네임에 해당 토큰이 있는 user 인덱스 번호 list}로 저장한다.
 *          2.3. Set를 통해 중복토큰 회원 저장한다.
 *
 *      3.  이메일 출력하는 기능
 *          3.1.이메일 오름차순으로 정렬한다.
 *
 */

public class Problem6 {

    // User 클래스
    static class User{
        private String email;
        private String nickname;


        public User(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }
        public String getNickname() {
            return nickname;
        }


    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
