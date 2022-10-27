package onboarding;

/** TODO
 * 1. 모든 자리 문자별로 뒤에 몇개까지 중복 되어있는지 확인
 * 2. 중복 된 만큼 제거
 * 3. 제거 했을 경우 flag true
 *  3-1. while문 flag true 일 경우 반복
 *  3-2. false 일 경우에는 마지막까지 중복 된 문자가 없고 제거된 것이 없으므로 종료
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        boolean decoding = true;

        while (decoding) {
            decoding = false;

            for (int i = 0; i < cryptogram.length() - 1; i++) {
                char currentChar = cryptogram.charAt(i);

                int count = 0;
                for (int j = i + 1; j < cryptogram.length(); j++) {
                    char nextChar = cryptogram.charAt(j);
                    if (currentChar != nextChar) {
                        break;
                    }
                    count = j - i + 1;
                }
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + count);

                if (count > 0) {
                    decoding = true;
                    i--;
                }
            }
        }
        return cryptogram;
    }
}
