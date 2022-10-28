package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 중복 문자가 처음 발생하는 index 구하기
        int startIndex = -1;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                startIndex = i;
                break;
            }
        }

        // 중복 문자가 존재하지 않는다면 기존 문자열을 return
        if (startIndex == -1) {
            return cryptogram;
        }

        // 연속한 중복 문자가 끝나는 index 구하기
        int endIndex = startIndex + 1;
        for (int i = endIndex; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                endIndex = i;
                break;
            }
        }

        // 중복 문자를 제거한 새로운 cryptogram 구하기
        String newCryptogram;
        if (startIndex == 0) {
            newCryptogram = cryptogram.substring(endIndex + 1);
            return solution(newCryptogram);
        }
        newCryptogram = cryptogram.substring(0, startIndex) + cryptogram.substring(endIndex + 1);
        return solution(newCryptogram);
    }
}
