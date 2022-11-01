package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    // 1. 예외처리 : 크루인원 1~10000 사이 체크.
    //
    public static boolean isException(List<List<String>> list){
        int length = list.size();
        if(length >= 1 && length <= 10000){
            for(List<String> check_list : list){
                // 이메일
                String email = check_list.get(0);
                // 이메일 유효성 체크.
                if(!checkEmail(email)){
                    // 이메일 유효성 검사를 통과 못한 경우 false
                    return false;
                }
                // 닉네임
                String nickname = check_list.get(0);
                // 닉네임 유효성 체크
                if(!checkNickname(nickname)){
                    // 닉네임 유효성 검사를 통과 못한 경우 false
                    return false;
                }
            }
            // list길이 조건을 통과하고 이메일, 닉네임 유효성 검사를 통과한다면 true
            return true;
        }
        // list길이 조건에 통과하지 못한다면 false
        return false;
    }

    // 이메일 유효성 체크 함수 만들기.
    public static boolean checkEmail(String email){
        String pattern = "^[a-zA-Z0-9]{1,9}$@email.com";
        return email.matches(pattern);
    }

    // 닉네임 유효성 체크 함수 만들기
    public static boolean checkNickname(String nickname){
        String pattern = "^[가-힣]{1,19}$";
        return nickname.matches(pattern);
    }

    // 중복 유효성 검사 함수.
    public static boolean isDuplicate(String cryptomgram){
        if(cryptomgram != null){
            for(int i = 1; i < cryptomgram.length(); i++){
                if(cryptomgram.charAt(i-1) != 0){
                    if(cryptomgram.charAt(i) == cryptomgram.charAt(i-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 2. 이메일 중복을 체크하는 함수 만들기.
    public static  List<String> checkMultiEmail(List<List<String>> list){
        List<String> result_list = new ArrayList<>();
        for(List<String> li : list){
            String email = li.get(0);
            String email_first = email.substring(0, email.indexOf("@"));
            if(!isDuplicate(email_first)){
                result_list.add(email);
            }
        }

        return result_list;
    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(isException(forms)){
            // result는 문자열을 오름차순으로 정렬
        }

        return answer;
    }
}
