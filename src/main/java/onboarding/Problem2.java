package onboarding;


import java.util.ArrayList;
import java.util.List;

// 중복된 문자열 검사
// 어렵다...
public class Problem2 {

    public static String overlapRemover(String cryptogram) {
        int cryptogramLength = cryptogram.length();
        List<String> stringToList = new ArrayList<>(cryptogramLength);

        // 입력 암호문 String 리스트로 치환
        for (int i = 0; i < cryptogramLength; i++) {
            stringToList.add(String.valueOf(cryptogram.charAt(i)));
        }

        int i = 0;

        while (i < stringToList.size() - 1) {
            String lowIndexValue = stringToList.get(i);
            String highIndexValue = stringToList.get(i + 1);

            if (lowIndexValue.equals(highIndexValue)) {
                stringToList.remove(i);
                stringToList.remove(i);
                i = 0;
            }
            else if (!lowIndexValue.equals(highIndexValue)) {
                i ++;
            }
        }

        // 암호 해독 후 문자열이 비어있으면 빈 문자열 반환
        if (stringToList.size() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (String element : stringToList) {
            result.append(element);
        }

        return result.toString();
    }

    public static String solution(String cryptogram) {
        return overlapRemover(cryptogram);
    }
}
