package onboarding;

/**
 * Problem 2
 *
 * 기능 요구 사항
 * 1. 임의의 문자열 cryptogram이 매개변수 주어진다.
 * 2. 연속하는 중복 문자들을 삭제한 결과 return
 *
 * 제한사항
 * 1. cryptogram은 길이가 1부터 1000이하인 문자열
 * 2. cryptogram은 알파벳 소문자로만 이루어져 있다.
 */
public class Problem2 {
    /**
     *
     * @param cryptogram
     * @return 중복 문자 삭제한 결과 값
     */
    public static String solution(String cryptogram) {
        String answer = "answer";
        try {
            if (cryptogram == null) {
                throw new Exception();
            }
            
            answer = Problem2.removeDup(cryptogram);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return answer;
    }

    /**
     * 중복된 문자 제거 함수
     * @param cryptogram
     * @return 중복 문자 제거된 값
     */
    public static String removeDup(String cryptogram){
        StringBuffer tempCryptogram = new StringBuffer();

        int index = 0;
        int top = -1;
        int stringSize = cryptogram.length();

        while (index < stringSize) {
            if (top != -1
                    && Problem2.isSameChar(tempCryptogram.charAt(top), cryptogram.charAt(index))) {
                tempCryptogram.deleteCharAt(top);
                top -= 1;
            } else {
                tempCryptogram.append(cryptogram.charAt(index));
                top += 1;
            }
            index += 1;
        }
        return tempCryptogram.toString();
    }

    /**
     * 두 문자가 같은지 비교하는 함수
     * @param origin
     * @param comp
     * @return 같으면 true, 다르면 false
     */
    public static boolean isSameChar(char origin, char comp) {
        return (origin == comp);
    }

}
