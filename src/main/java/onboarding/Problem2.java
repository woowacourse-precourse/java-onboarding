package onboarding;

public class Problem2 {
    /**
     * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하는 solution 메서드
     * @param cryptogram 암호문
     * @return 중복 문자를 모두 제거한 cryptogram
     */
    public static String solution(String cryptogram) {
        if (!isValid(cryptogram)) return  "false";
        while(isDuplicate(cryptogram) != -1) {
            cryptogram = deleteDuplicate(cryptogram);
        }
        return cryptogram;
    }

    /**
     * 제한 사항 검증
     * @param cryptogram 주어진 문자열
     * @return 문자열의 길이가 1미만, 1000초과일 경우, 대문자가 있는 경우 false, 이외의 경우 true
     */
    public static boolean isValid(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1) return false;
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (Character.isUpperCase(c)) return false;
        }
        return true;
    }

    /**
     * 문자열의 중복이 있는지 확인하는 method
     * @param cryptogram 주어진 문자열
     * @return 중복이 시작되는 부분의 인덱스
     */
    public static int isDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            char nowChar = cryptogram.charAt(i);
            char nextChar = cryptogram.charAt(i+1);
            if (nowChar == nextChar) return i;
        }
        return -1;
    }

    /**
     * 중복 부분 문자 제거 method
     * @param cryptogram 주어진 문자열
     * @return 중복 제거를 완료한 문자열
     */
    public static String deleteDuplicate(String cryptogram) {
        int duplicateIndex = isDuplicate(cryptogram);
        StringBuffer temp = new StringBuffer(cryptogram);
        temp.delete(duplicateIndex, duplicateIndex+2);
        String result = new String(temp);
        return result;
    }
}
