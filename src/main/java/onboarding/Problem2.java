package onboarding;

/**
 * 기능
 * 1. 입력 문자열 길이 확인
 * 2. 바꿀 인덱스가 있는지 확인
 * 3. 중복값 바꾸기
 */
public class Problem2 {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    public static String solution(String cryptogram) {
        if (isValidLength(cryptogram))
            return calc(cryptogram);
        return "";
    }

    /**
     * 1. 입력 문자열 길이 확인
     * @param str
     * @return 조건 해당시 true 반환
     */
    static boolean isValidLength(String str){
        int len=str.length();
        return len>=MIN_LENGTH && len <=MAX_LENGTH;
    }

    /**
     * 2. 바꿀 값이 있는지 확인
     * @param str
     * @return 바꿀 값이 있는 위치의 시작 인덱스 반환
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
     * 3. 중복값 바꾸기
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
