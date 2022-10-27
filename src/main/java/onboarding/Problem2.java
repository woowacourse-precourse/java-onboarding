package onboarding;

public class Problem2 {

    /**
     * 기능 목록
     * 1. 중복된 문자 있는지 체크
     * 2. 중복된 문자 제거
     */

    /**
     * 1. 중복된 문자 있는지 체크
     * @param cryptogram : 체크할 암호문
     * @return : 중복된 문자가 있으면 해당 문자열 인덱스 값, 없으면 -1
     */

    static int checkDuplicate(String cryptogram) {
        for(int i = 0; i < cryptogram.length() - 1; i++){
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) return i;
        }

        return -1;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
