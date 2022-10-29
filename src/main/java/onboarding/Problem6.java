package onboarding;

import java.util.List;

public class Problem6 {
    /* checkEmail: 이메일형식이 email.com인지 확인하는 함수 */
    public static boolean checkEmail(String email){
        if(email.matches("(.*)@email.com")){
            return true;
        }
        return false;
    }
    /* checkKor: 닉네임이 한글로만 이루어져있는지 확인하는 함수 */
    public static boolean checkKor(String name){
        if(name.matches("[ㄱ-ㅎ가-힣]+")){
            return true;
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");



        return answer;
    }
}