package onboarding;

import java.util.List;
/*
1. 예외 처리:
    초반 예외: 크루원 1이상10000이하 검증
    이중for문 내 예외 : 이메일length 11이상 20미만 검증 / 이메일 @ 이후 문자 "email.com" 인지 검증 / 닉네임length 1이상 20미만 검증
2. 이중for문 사용하여 크루원 이메일 비교
    비교 방식 :
        이메일에서 @email.com 잘라내기
        jason -> [ja,as,so,on]으로 분리하여 jason 뒤에 있는 크루원 이메일에 contains 시도
        중복이 있으면 이메일 저장
    저장된 이메일 리턴
3. 저장된 이메일 리턴
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(checkMemberLimit(forms)){
            return null;
        }
        return answer;
    }

    private static boolean checkMemberLimit(List<List<String>> forms){
        // 크루원 1 이상 10000 이하 검증
        if (forms.size() >= 1 && forms.size() <= 10000){
            return false;
        }
        return true;
    }
}
