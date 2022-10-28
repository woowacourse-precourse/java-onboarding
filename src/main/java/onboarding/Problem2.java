package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 구현 기능 목록
 * 1. 문자열에서 연속으로 중복된 문자의 인덱스 찾기
 * 2. 인덱스를 통해 연속으로 중복된 문자열 부분 구하기
 * 3. 문자열에서 연속으로 중복된 문자 삭제
 * 4. 문자열이 암호화되어 있는지 검사
 * 5. 암호문 복호화
 * */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (isEncryption(answer)) {
            answer = decryption(answer);
        }
        return answer;
    }

    private static List<Integer> getRedundancyLetterIndex(String cryptogram) {
        List<Integer> redundancyLetterIndex = new ArrayList<>();
        for (int i =0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                redundancyLetterIndex.add(i);
                redundancyLetterIndex.add(i+1);
            }
        }
        return redundancyLetterIndex.stream().distinct().collect(Collectors.toList());
    }

    private static List<String> getRedundancyLetters(List<Integer> indexes, String cryptogram) {
        List<String> redundancyLetters = new ArrayList<>();
        int checkPoint = indexes.get(0);
        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) != checkPoint && indexes.get(i) != indexes.get(i-1)+1) {
                redundancyLetters.add(cryptogram.substring(checkPoint, indexes.get(i-1)+1));
                checkPoint = indexes.get(i);
            }
        }
        redundancyLetters.add(cryptogram.substring(checkPoint, indexes.get(indexes.size()-1)+1));

        return redundancyLetters;
    }

    private static String deleteRedundancyLetter(List<String> redundancyLetters, String cryptogram) {
        for (String redundancy : redundancyLetters)
            cryptogram = cryptogram.replace(redundancy, "");

        return cryptogram;
    }

    private static boolean isEncryption(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1))
                return true;
        }
        return false;
    }

    private static String decryption(String cryptogram) {
        cryptogram = deleteRedundancyLetter(getRedundancyLetters(getRedundancyLetterIndex(cryptogram), cryptogram), cryptogram);
        return cryptogram;
    }
}
