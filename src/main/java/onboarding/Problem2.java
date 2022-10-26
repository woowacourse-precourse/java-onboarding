package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2 {
    /*feat 2.1: LinkedList에 문자들을 넣는다.
  feat 2.2: List를 순회하면서 i번째 항과 i+1번째 항이 같은지 검사한다.(중복된 값 있는지 검사)
  feat 2.3: 같으면 해당 값들 삭제, i=0으로 초기화한다. */
    public static List<String> list;

    public static String solution(String cryptogram) {
        String answer = "answer";
        list = new LinkedList<String>();

        addLettersInList(cryptogram);
        traverseList(list);
        //searchSameLetter();

        return answer;
    }

    private static void traverseList(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
           if (list.get(i).equals(list.get(i + 1))) {
            }
        }
    }

    private static void addLettersInList(String cryptogram) {
        StringTokenizer st = new StringTokenizer(cryptogram);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
    }
}
