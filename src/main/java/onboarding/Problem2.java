package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }

    public static String solution(String cryptogram) {
        // 1. 받은 문자열을 String으로 나눠서 ArrayList로 저장
        // 2. 내용에 바로 중복해서 나오는 문자가 있는지 확인하는 메서드 생성
        // 3. 중복하는 문자가 있으면 제거하는 메서드 생성
        // 4. 중복하는 문자가 없으면 String으로 반환

        // 매개변수로 받은 cryptogram 문자열을 ArrayList로 변환
        String[] arrayOfCryptoString = cryptogram.split("");
        List<String> listOfCryptoString = new ArrayList<>(Arrays.asList(arrayOfCryptoString));
        boolean isRepeat = false;

        do {
            isRepeat = isRepeatChar(listOfCryptoString);

        } while (isRepeat == true);

        String answer = "answer";
        return answer;
    }

    private static boolean isRepeatChar(List<String> listOfCryptoString) {
        for (int i = 1; i < listOfCryptoString.size(); i++) {
            if (listOfCryptoString.get(i - 1).equals(listOfCryptoString.get(i))) {
                return true;
            }
        }
        return false;
    }
}
