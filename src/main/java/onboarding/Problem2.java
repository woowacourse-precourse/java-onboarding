package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String sol = "";
        int count = 0;


        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();
        for (int i=0;i<cryptogram.length();i++) {
            char currentChr = cryptogram.charAt(i);
            list.add(currentChr);
        }
        for (int i=1;i<list.size();i++) {
            if (list.get(i)==list.get(i-1)) {
                list.remove(i);
                list.remove(i-1);
                i--;
                count++;
            }
            if (i==list.size()-1 && count!=0) {
                count=0;
                i=1;
                continue;
            } else if (i==list.size()-1) {
                break;
            }
        }
        for (int i=0;i<list.size();i++) {
            sol += list.get(i);
        }





        answer = sol;


        return answer;
    }
}
