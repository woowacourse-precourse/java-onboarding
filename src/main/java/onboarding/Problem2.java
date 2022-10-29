package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        return cryptogram;
    }

    static List<Integer> makeRemoveRange(String cryptogram){
        CheckLetter checkletter = new CheckLetter(cryptogram);
        List<Integer> remove_range;

        while(checkletter.checkLoop()){
            checkletter.letterCheck();
        }
        remove_range = checkletter.getRemove_range();
        return remove_range;
    }

    static class CheckLetter {
        int front = 0;
        int back = 1;
        List<Integer> remove_range = new ArrayList<>();
        String cryptogram;

        CheckLetter(String cryptogram) {
            this.cryptogram = cryptogram;
        }
        List<Integer> getRemove_range() {
            return remove_range;
        }
        boolean checkLoop() {
            return back != cryptogram.length();
        }
        void letterCheck () {
            if (cryptogram.charAt(front) != cryptogram.charAt((back))) {
                this.workMismatch();
            } else if (cryptogram.charAt(front) == cryptogram.charAt(back)) {
                this.workMatch();
            }
        }
        void workMismatch() {
            if (back == cryptogram.length() - 1) {
                back += 1;
            } else if (back - front == 1) {
                back += 1;
                front += 1;
            } else if (back - front > 1) {
                remove_range.add(back);
                back += 1;
                front = back - 1;
            }
        }
        void workMatch() {
            if (back == cryptogram.length() - 1) {
                back += 1;
                remove_range.add(back);
            } else if (back - front == 1) {
                remove_range.add(front);
                back += 1;
            } else if (back - front > 1) {
                back += 1;
            }
        }
    }
}
