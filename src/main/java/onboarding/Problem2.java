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



    public static List<Character> deleteSame(List<Character> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i);
                list.remove(i);
            }
        }
        return list;
    }

    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> list = stringToList(cryptogram);
        System.out.println("list = " + list);

        while (true) {
            deleteSame(list);
            break;
        }
        System.out.println("list = " + list);
        return answer;
    }
}