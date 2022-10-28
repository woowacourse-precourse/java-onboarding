package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        String decoding = cryptogram;
        String decoded;
        while (true) {
            indexs.clear();
            search(decoding, indexs);
            decoded = delete(decoding, indexs);
            if(decoding.equals(decoded)) {
                break;
            }
            decoding = decoded;
        }
        String answer = decoded;
        return answer;
    }

    public static void search(String decoding, ArrayList<Integer> indexs) {
        char[] charArray = decoding.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                indexs.add(i);
            }
        }
    }

    public static String delete(String decoding, ArrayList<Integer> indexs) {
        char[] charArray = decoding.toCharArray();
        for (int i = 0; i < indexs.size(); i++) {
            charArray[indexs.get(i)] = '?';
            charArray[indexs.get(i) + 1] = '?';
        }
        return String.valueOf(charArray).replace("?", "");
    }



}
