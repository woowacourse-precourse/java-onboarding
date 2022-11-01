package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> filteredCrewList = detectCrewOfAll(forms);
        List<String> answer = new ArrayList<>(filteredCrewList);
        return answer;
    }

    /*
     * 같은 글자가 연속적으로 포함되는 교육생을 찾아 이메일 목록에 추가하여 반환
     */
    public static TreeSet<String> detectCrewOfAll(List<List<String>> crewAllList) {
        TreeSet<String> filteredCrewList = new TreeSet<>();
        for (int i = 0; i < crewAllList.size() - 1; i++) {
            String checkerNickName = crewAllList.get(i).get(1);
            boolean exited = false;

            for (int j = 1+i; j < crewAllList.size() - 1; j++) {
                String nickName = crewAllList.get(j).get(1);
                if (checkConsecutiveLetter(checkerNickName, nickName)) {
                    exited = true;
                    filteredCrewList.add(crewAllList.get(j).get(0));
                }
            }
            if (exited) {
                filteredCrewList.add(crewAllList.get(i).get(0));
            }
        }
        System.out.println(filteredCrewList);
        return filteredCrewList;
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
