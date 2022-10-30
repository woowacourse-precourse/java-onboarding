package onboarding;

public class Problem2 {
    public static String deduplicate(String cryptogram) {
        char prev = ' ';
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == prev) {
                // 새로운 string 생성
                String newCryptogram = cryptogram.substring(0, i - 1);
                newCryptogram += cryptogram.substring(i + 1);
                return newCryptogram;
            }
            else {
                prev = cryptogram.charAt(i);
            }
        }
        return "decode complete";
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        do {
            cryptogram = deduplicate((cryptogram));
            if (cryptogram.equals("decode complete")) {
                break;
            }
            answer = cryptogram;
        } while (true);
        return answer;
    }
}
