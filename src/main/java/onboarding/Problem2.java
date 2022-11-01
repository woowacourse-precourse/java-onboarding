package onboarding;

/**
 * 기능목록
 * 1. 중복된 문자의 인덱스를 기능
 * 2. 1에서 중복된 문자가 있을 시 해당 문자를 삭제하는 기능
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            int duplicationNum = findDuplication(answer);
            if (duplicationNum == -1) {
                break;
            }
            answer = removeDuplication(duplicationNum, answer);
        }
        return answer;
    }

    /**
     * 기능 1
     * @param check
     * @return 중복된 문자가 있으면 중복시작 인덱스, 없으면 -1
     */
    private static int findDuplication(String check) {
        for (int i = 0; i < check.length()-1; i++) {
            if (check.charAt(i) == check.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 기능 2
     * @param duplicationNum
     * @param check
     * @return duplicationNum 번째와 duplictionNum+1 번째 문자를 제거한 문자열
     */
    private static String removeDuplication(int duplicationNum, String check) {
        StringBuffer originalString = new StringBuffer(check);
        return originalString.replace( duplicationNum ,duplicationNum+2 ,"").toString();
    }
}
