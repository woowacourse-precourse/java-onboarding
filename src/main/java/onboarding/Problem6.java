package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;

    }

    /*
     * 한 닉네임에 대해 같은 글자가 연속적으로 포함되는 교육생을 찾아 이메일 목록에 추가
     */
    public static void detectCrewOfAll(String nickName) {

    }


    /*
     * 주어진 두 닉네임에 대해서 같은 글자가 연속적으로 포함되는지를 검사하여 반환
     */
    public static boolean checkConsecutiveLetter(String text, String checkText) {
        List<String> consecutiveLetters = generateConsecutiveLetters(text);
        for (String letter : consecutiveLetters) {
            if (checkText.contains(letter)) {
                return true;
            }
        }
        return false;
    }

    /*
     * 주어진 닉네임에 대해, 생성될 수 있는 모든 문자열을 생성하여 반환
     */
    public static List<String> generateConsecutiveLetters(String nickName) {
        List<String> consecutiveLetterList = new ArrayList<>();

        for (int i = 2; i <= nickName.length(); i++) {
            for (int j = 0; j < nickName.length() - 1; j++) {
                if ((j + i) > nickName.length()) {
                    break;
                }
                consecutiveLetterList.add(nickName.substring(j,
                        j + i));
            }
        }
        return consecutiveLetterList;
    }

}
