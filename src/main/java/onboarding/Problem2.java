package onboarding;

/**
 * 기능 사항
 * a. 삭제할 값이 있는지 확인
 * b. 삭제할 값이 있을 경우 삭제
 */
public class Problem2 {
    /**
     * a. 삭제할 값이 있는지 확인
     * @param cryptogram
     * @return 삭제할 값의 시작 index
     */
    static int checkPossible(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return i;
        }
        return -1;
    }

    /**
     * b. 삭제할 값이 있을 경우 삭제
     * @param cryptogram
     * @return cryptogram을 재귀로 하나씩 삭제. 만약 바꿀값이 없을 경우(index == -1) 복호화된 cryptogram 반환
     */

    static String calc(String cryptogram){
        int left = checkPossible(cryptogram);
        if(left == -1) return cryptogram;

        int right;
        for(right = left; right< cryptogram.length(); right++){
            if(cryptogram.charAt(left) == cryptogram.charAt(right)) continue;
            break;
        }
        cryptogram = cryptogram.substring(0, left) + cryptogram.substring(right);
        return calc(cryptogram);
    }

    public static String solution(String cryptogram) {return calc(cryptogram);}
}