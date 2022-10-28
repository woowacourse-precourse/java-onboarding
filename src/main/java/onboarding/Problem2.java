package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        if (cryptogram.length() == 0) {
            return cryptogram;
        }

        String answer = "";
        boolean flag = true;
        ArrayList<Character> cryptogramList = new ArrayList<>();
        int idx1, idx2;
        int i;

        for (i = 0; i < cryptogram.length(); i++) {
            cryptogramList.add(cryptogram.charAt(i));
        }

        while (flag) {
            flag = false;
            idx1 = 0;

            while (idx1 < cryptogramList.size()) {
                idx2 = idx1 + 1;
                char target = cryptogramList.get(idx1);

                while (idx2 < cryptogramList.size()) {
                    if (target != cryptogramList.get(idx2))
                        break;
                    idx2 += 1;
                }

                if (idx1 + 1 < idx2) {
                    for (i = idx1; i < idx2; i++) {
                        cryptogramList.remove(idx1);
                    }
                    flag = true;
                }

                idx1 = idx2;
            }
        }

        for (char c : cryptogramList) {
            answer += c;
        }

        return answer;
    }

}

