package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> list =stringToArrayList(cryptogram);
        ArrayList<Character> result = decryption(list);
        String answer = ArrayListToString(result);
        return answer;
    }

    private static ArrayList<Character> stringToArrayList(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            list.add(currentCharacter);
        }
        return list;
    }

    private static ArrayList<Character> decryption(ArrayList<Character> list) {
        int cnt = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i - 1 >= 0 && list.get(i) == list.get(i-1)) {
                list.remove(i);
                cnt++;
            } else {
                if (cnt > 0) {
                    list.remove(i);
                    break;
                }
            }
        }
        if (cnt > 0) {
            return decryption(list);
        } else {
            return list;
        }
    }

    private static String ArrayListToString(ArrayList<Character> characters) {
        String str = "";
        for (Character character : characters) {
            str += character;
        }
        return str;
    }
}

