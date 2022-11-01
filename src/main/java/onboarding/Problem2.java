package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        checkCryptogramCorrect(cryptogram);

        return decryptCryptogram(cryptogram);
    }

    /**
     * 암호가 올바른지 검증
     * @param cryptogram 암호
     * @throws RuntimeException 오류 메세지를 반환
     */
    private static void checkCryptogramCorrect(String cryptogram) {
        int lengthCryptogram = cryptogram.length();

        if (lengthCryptogram == 0 || lengthCryptogram > 1000) {
            throw new RuntimeException("암호문은 1 ~ 1000 글자여야 합니다.");
        }

        if (!Pattern.matches("^[a-z]*$", cryptogram)) {
            throw new RuntimeException("암호문은 알파벳 소문자로만 구성되어야 합니다.");
        }
    }

    /**
     * 중복 문자를 제거하여 복호화
     * @param cryptogram 암호
     * @return 복호환된 단어
     */
    private static String decryptCryptogram(String cryptogram) {
        List<String> oneLetterCryptograms = getOneLetterCryptograms(cryptogram);
        int sizeOneLetterCryptograms = oneLetterCryptograms.size();

        for (int oneLetterIndex = 1; oneLetterIndex < sizeOneLetterCryptograms; oneLetterIndex++) {
            String previousOneLetter = oneLetterCryptograms.get(oneLetterIndex - 1);
            String currentOneLetter = oneLetterCryptograms.get(oneLetterIndex);

            if (Objects.equals(previousOneLetter, currentOneLetter)) {
                for (int i = 0; i < 2; i++) {
                    oneLetterCryptograms.remove(oneLetterIndex);
                    sizeOneLetterCryptograms--;
                    oneLetterIndex--;
                }
            }
        }

        return String.join("", oneLetterCryptograms);
    }

    /**
     * 암호를 한글자씩 분할하기
     * @param cryptogram 암호
     * @return 한글자씩 분할된 암호
     */
    private static List<String> getOneLetterCryptograms(String cryptogram) {
        List<String> oneLetterCryptogram = new LinkedList<>();
        Collections.addAll(oneLetterCryptogram, cryptogram.split(""));

        return oneLetterCryptogram;
    }

}
