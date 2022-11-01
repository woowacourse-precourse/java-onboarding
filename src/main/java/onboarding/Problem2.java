package onboarding;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static List<Character> stringToList (String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    public static String listToString (List<Character> list) {
        String answer = "";
        for (int i =0; i < list.size(); i ++) {
            answer += list.get(i);
        }
        return answer;
    }

    public static void deleteSame(List<Character> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i);
                list.remove(i);
            }
        }
    }

    public static String solution(String cryptogram) {
        String answer;
        List<Character> list = stringToList(cryptogram);
        int size = list.size();
        for (int i = 0; i < size / 2; i++) deleteSame(list);
        answer = listToString(list);
        return answer;
    }
}