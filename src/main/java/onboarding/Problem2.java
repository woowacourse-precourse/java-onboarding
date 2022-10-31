package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> lst = new ArrayList<>();
        char[] cryp = cryptogram.toCharArray();
        for(char c : cryp) lst.add(c);

        int chk = 0;
        char tmp;
        int cur;
        int next;
        while(chk == 0 && lst.size() > 0) {
            chk = 1;
            cur = 0;
            next = 1;
            while (next < lst.size()) {
                if (lst.get(cur) == lst.get(next)) {
                    chk = 0;
                    tmp = lst.get(cur);
                    lst.remove(cur);
                    while (lst.size() > 0 && tmp == lst.get(cur)) {
                        lst.remove(cur);
                    }
                } else {
                    cur++;
                    next++;
                }
            }
        }
        String answer = "";
        if (lst.size() != 0) {
            for (char i : lst) {
                answer += i;
            }
        }
        return answer;
    }
}
