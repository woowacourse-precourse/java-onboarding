package onboarding;

import java.util.List;

public class Problem6 {

    // 1. 예외처리 : 크루인원 1~10000 사이 체크.
    //
    public static boolean isException(List<List<String>> list){
        int length = list.size();
        if(length >= 1 && length <= 10000){
            for(int i = 0; i<length; i++){
                // 이메일
                String email = list.get(i).get(0);
                // 이메일 유효성 체크.
                if(checkEmail(email)){

                }
            }
        }
        return false;
    }

    // 이메일 형식체크 함수 만들기.
    public static boolean checkEmail(String email){
        if(email.length() >= 11 && email.length() < 20){
            String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com";
            return email.matches(pattern);
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        // 1. 예외처리 : 크루 인원이 1~10000 사이인지 체크하기.
        // 이메일 : 11자이상 20자 미만 체크하기.
        // email.com 도메인 제한 체크하기.
        // 닉네임은 한글만 가능. 길이는 1~20 사이 체크하기.
        // result는 문자열을 오름차순으로 정렬
        // 2. 이름중복을 체크하는 함수 만들기.
        return answer;
    }
}
