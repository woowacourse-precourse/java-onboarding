package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for(List<String> crew : forms) {
            if(!check_email(crew.get(0)) || !check_nickname(crew.get(1))) { // 이메일, 닉네임 형식 검사
                // todo 에러처리
            }
        }
        // todo answer 오름차순 정렬
        return answer;
    }

    /**
     * 이메일 형식 검사 함수
     * @param email
     * @return
     */
    public static boolean check_email(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com$";
        if(email.length() < 11 || email.length() >= 20) return false; // 길이 예외처리
        return Pattern.matches(regex, email); // 도메인 예외처리
    }

    /**
     * 닉네임 형식 검사 함수
     * @param nickname
     * @return
     */
    public static boolean check_nickname(String nickname) {
        String regex = "^[가-힣]*$";
        if(nickname.length() < 1 || nickname.length() >= 20) return false; // 길이 예외처리
        return Pattern.matches(regex, nickname); // 한글 예외처리
    }
}
