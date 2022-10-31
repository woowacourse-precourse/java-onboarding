package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        /* 
        결국 연속되어 pop되는 문자들을 모두 지우면 됨
        1. 문자열을 순회하며 중복을 체크하여 삭제하는 함수 작성 ( return string )
        2. while 루프를 돌며 삭제가 이루어지지 않을 때 까지 반복
        */
        return answer;
    }
    /*
    암호 해독 순서를 중간 skip할 수 있지만, 해독 결과는 같다.
    */
    static String deleteContinuity(String s){
        for ( int i = 0 ; i < s.length() ; i ++ ){
            String pattern = "["+s.charAt(i)+"]{2,}";
            s = s.replaceAll(pattern,"");
        }
        return s;
    }
}
