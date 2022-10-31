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

    /**
     * 2. 중복된 문자 제거
     * @param cryptogram : 중복된 문자를 제거할 암호문
     * @return : 재귀함수로 다른 중복된 문자 제거 함수 호출, 만약 제거할 것이 없다면 암호문 리턴
     */
    static String removeDuplicate(String cryptogram){
        int checking = checkDuplicate(cryptogram);
        if (checking == -1) return cryptogram;

        int start = checking;
        int end = start + 1;
        for (; end < cryptogram.length(); end++){
            if (cryptogram.charAt(start) == cryptogram.charAt(end)) continue;
            else break;
        }

        cryptogram = cryptogram.substring(0, start) + cryptogram.substring(end);

        return removeDuplicate(cryptogram);
    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicate(cryptogram);
        return answer;
    }
}
