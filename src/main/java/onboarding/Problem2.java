package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> cryptList = splitCryptogram(cryptogram);
        String answer = decode(cryptList);
        return answer;
    }

    // 암호문 배열로 분리
    private static List<String> splitCryptogram(String cryptogram) {
        return Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
    }

    // 중복되는 문자열 제거
    private static String decode(List<String> cryptogramList) {
        int index = 1;
        while (index < cryptogramList.size()) {
            if (isDuplicateInCryptogram(cryptogramList, index)) return decode(cryptogramList);
            index++;
        }
        return String.join("", cryptogramList);
    }

    // 중복 여부 확인
    private static boolean isDuplicateInCryptogram(List<String> cryptList, int index) {
        if (cryptList.get(index).equals(cryptList.get(index - 1))) {
            cryptList.remove(index);
            cryptList.remove(index - 1);
            return true;
        }
        return false;
    }


}
