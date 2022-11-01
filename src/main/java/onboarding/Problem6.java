package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for(List<String> crew : forms) {
//            if(!check_email(crew.get(0)) || !check_nickname(crew.get(1))) { // 이메일, 닉네임 형식 검사
//                // todo 에러처리
//            }
        }
        // todo answer 오름차순 정렬
        return answer;
    }

//    /**
//     * 이메일 형식 검사 함수
//     * @param email
//     * @return
//     */
//    public static boolean check_email(String email) {
//        if(email.length() < 11 || email.length() >= 20) return false;
//        // 이메일 정규식 검사
//        return true;
//    }

    /**
     * 닉네임 형식 검사 함수
     * @param nickname
     * @return
     */
    public static boolean check_nickname(String nickname) {
        String regex = "^[가-힣]*$";
        if(nickname.length() < 1 || nickname.length() >= 20) return false;
        return Pattern.matches(regex, nickname);
    }
}
