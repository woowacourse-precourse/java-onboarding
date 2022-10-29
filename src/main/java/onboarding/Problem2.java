package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 매개변수로 받은 cryptogram 문자열을 ArrayList로 변환
        String[] arrayOfCryptoString = cryptogram.split("");
        List<String> listOfCryptoString = new ArrayList<>(Arrays.asList(arrayOfCryptoString));
        boolean isContinuous = false;

        // 반복되는 문자가 있는지 확인하며 있으면 삭제하는 기능을 반복
        do {
            isContinuous = removeContinuousChar(listOfCryptoString);
        } while (isContinuous == true);

        return getAnswer(listOfCryptoString);
    }

    private static boolean removeContinuousChar(List<String> listOfCryptoString) {
        for (int i = 1; i < listOfCryptoString.size(); i++) {
            if (listOfCryptoString.get(i - 1).equals(listOfCryptoString.get(i))) {
                listOfCryptoString.remove(i);
                listOfCryptoString.remove(i - 1);
                return true;
            }
        }
        return false;
    }

    private static String getAnswer(List<String> listOfCryptoString) {
        String answer = "";
        for (int i = 0; i < listOfCryptoString.size(); i++) {
            answer += listOfCryptoString.get(i);
        }
        return answer;
    }
}
