package onboarding;

/**
 * @Problem: 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 */
public class Problem2 {
    private static String deleteContinuousCharacter(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        cryptogram = cryptogram + '!'; // 허수 추가
        char temp = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            char next = cryptogram.charAt(i);
            if (temp != next) {
                sb.append(temp);
                temp = next;
            } else {
                temp = cryptogram.charAt(++i);
            }
        }
        return sb.toString();
    }

    private static String decodeCryptogram(String cryptogram) {
        String tempCryptogram = cryptogram;
        while (tempCryptogram.length() > 0) {
            String nextCryptogram = deleteContinuousCharacter(tempCryptogram);
            // 문자열 비교
            if (tempCryptogram.equals(nextCryptogram)) {
                return tempCryptogram;
            }
            tempCryptogram = nextCryptogram;
        }
        return null;
    }

    public static String solution(String cryptogram) {
        return decodeCryptogram(cryptogram);
    }
}
