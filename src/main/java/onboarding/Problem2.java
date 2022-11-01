package onboarding;

class Cryptogram {
    private String cryptogram;

    public Cryptogram(final String cryptogram) {
        validateCryptogram(cryptogram);
        this.cryptogram = cryptogram;
    }

    public String toString() {
        return this.cryptogram;
    }

    private void validateCryptogram(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {    // 길이 1이상 1000이하 문자
            throw new IllegalArgumentException("A Length of cryptogram must be between 1 and 1000");
        }
        if (!cryptogram.matches("^[a-z]*$")) {   // 소문자만 포함
            throw new IllegalArgumentException("A cryptogram must be lower alphabets.");
        }
    }
}

class Decoder {
    private Cryptogram cryptogram;

    public Decoder(Cryptogram cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String decode() {
        String prev = "";
        String code = this.cryptogram.toString();
        while (!prev.equals(code)) {
            if (code.equals("")) {
                return "";
            }
            prev = code;
            code = decodeOnce(code);
        }
        return code;
    }

    private String decodeOnce(String code) {
        /* i번 째부터 j번 째까지 문자가 같은지 확인하고, 중복된 경우 제거 */
        int i = 0;  // 시작 문자 인덱스
        int j = i + 1;  // 끝 문자 인덱스
        while (j < code.length()) {
            if (code.charAt(i) == code.charAt(j) && j + 1 == code.length()) {     // i번째 문자와 j번째 문자가 같고, j번째 문자가 마지막 문자이면
                code = code.substring(0, i);    // 연속 문자열 제거 후
                j += 1;  // 반복문 빠져나감.
                continue;
            }
            if (code.charAt(i) == code.charAt(j) && j + 1 != code.length()) {     // i번째 문자와 j번째 문자가 같고, j번째 문자가 마지막 문자가 아니면
                j += 1; //  다음 문자도 같은지 확인
                continue;
            }
            if (code.charAt(i) != code.charAt(j) && i + 1 == j) {     // i번째 문자와 j번째 문자가 다르고, i와 j가 1 차이인 경우 다음 인덱스 체크
                i += 1;
                j += 1;
                continue;
            }
            if (code.charAt(i) != code.charAt(j) && i + 1 < j) {      // i번째 문자와 j번째 문자가 다르고, i와 j사이에 반복된 문자가 있는 경우 반복 문자 제거
                code = code.substring(0, i) + code.substring(j);
                j = i + 1;
            }
        }
        return code;
    }
}

public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptogram code = new Cryptogram(cryptogram);
        Decoder decoder = new Decoder(code);
        String answer = decoder.decode();
        return answer;
    }
}