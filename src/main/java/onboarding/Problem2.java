package onboarding;

/**
 * 1. 중복문자 존재하는지 확인
 * 2. 중복문자 존재시 중복문자 제거
 * 3. 중복문자가 존재하지 않는 결과값 반환
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }


    //중복문자 존재하는지 구별하는 함수
    //중복문자가 존재할시 true를 반환해준다.
    public static boolean isDuplicate(String cryptogram){
        for(int i = 1 ; i < cryptogram.length() ; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)){
                return true;
            }
        }
        return false;
    }
}
