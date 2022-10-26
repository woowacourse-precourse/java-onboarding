package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        ArrayList<Integer> overlapIndex = findOverlapIndex(cryptogram);
        remove(cryptogram,overlapIndex);
        cryptogram = remove(cryptogram,overlapIndex);
        if (overlapIndex.isEmpty()) {
            return cryptogram;
        }


        return solution(cryptogram);
    }

    static ArrayList<Integer> findOverlapIndex(String cryptogram) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = cryptogram.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                list.add(i-1);
                list.add(i);
            }
        }
        return list;
    }

    static String remove(String cryptogram,ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram);

        for (int i = 0; i < list.size(); i++) {
            sb.delete(list.get(0), list.get(1));
            cryptogram= String.valueOf(sb);
        }

        return cryptogram;
    }
}
