package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String decryption = null; // 연속으로 중복된 문자를 제거한 결과

        // 중복을 제거한 결과가 이전과 다르면 계속 진행한다.
        while (!(decryption = decode(cryptogram)).equals(cryptogram)) {
            cryptogram = decryption;
        }

        return decryption;
    }

    /**
     * @param cryptogram 중복문자가 포함된 문자열
     * @return 중복된 문자가 있다면 이를 제거한 결과를 반환한다.
     */
    public static String decode(String cryptogram) {
        if (cryptogram == null || cryptogram.equals(null)) {
            return null;
        }

        int size = cryptogram.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {

            // i번째 문자열의 좌우로 같은 문자열이 오는지 확인한다.
            if (i + 1 < size && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                continue;
            }
            if (i - 1 >= 0 && cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                continue;
            }
            result.append(cryptogram.charAt(i));
        }
        return result.toString();
    }
}