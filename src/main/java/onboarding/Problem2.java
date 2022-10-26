package onboarding;

/** 기능 사항
 * 1. 바꿀 값이 있는지 확인하는 함수
 * 2. 바꿀 값이 있을 경우 바꾸는 함수
 */
public class Problem2 {
    /**
     * 1. 바꿀 값이 있는지 확인하는 함수
     * @param s
     * @return 바꿀값이 시작되는 index를 return
     */
    static int checkPossible(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return i;
        }
        return -1;
    }

    /**
     * 2. 바꿀 값이 있을 경우 바꾸는 함수
     * @param cryptogram
     * @return 바꿔진 값을 재귀로 리턴 만약 바꿀값이 없을 경우 String 반환
     */

    static String calc(String cryptogram){
        int res = checkPossible(cryptogram);
        if(res == -1) return cryptogram;
        int end = res;
        for(; end< cryptogram.length(); end++){
            if(cryptogram.charAt(res) == cryptogram.charAt(end)) continue;
            break;
        }
        cryptogram = cryptogram.substring(0, res) + cryptogram.substring(end);
        return calc(cryptogram);

    }


    public static String solution(String cryptogram) {
        return calc(cryptogram);

    }
}
