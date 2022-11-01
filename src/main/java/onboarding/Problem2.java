package onboarding;

/**
 * 기능 1. 바꿀 인덱스가 있는지 확인 2. 바꿀 값이 있으면 바꾼다.
 */
public class Problem2 {

    public static String solution(String cryptogram) {
        return calc(cryptogram);
    }

    /**
     * 1. 바꿀 값이 있는지 확인
     *
     * @param str
     * @return 바꿀 값이 있는 위치의 시작 인덱스를 반환함
     */
    static int checkChange(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 2. 바꿀 값이 있다면 그부분을 삭제하는 함수
     *
     * @param cryptogram
     * @return 최종 바꾼 값을 반환
     */
    static String calc(String cryptogram) {
        while (true) {
            int idx = checkChange(cryptogram);
            if (idx == -1) {
                return cryptogram;
            }
            int end = idx;
            for(;end<cryptogram.length();end++){
                if(cryptogram.charAt(idx)==cryptogram.charAt(end)) continue;
                break;
            }
            cryptogram=cryptogram.substring(0,idx)+cryptogram.substring(end);
            return calc(cryptogram);
        }
    }

}
