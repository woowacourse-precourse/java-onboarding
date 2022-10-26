package onboarding.problem2;

import java.util.ArrayList;
import java.util.List;

public class Cryptogram {

    private List<Character> chrList = new ArrayList<>();
    public Cryptogram(String str) {
        mapString(str);
    }

    private void mapString(String str) {
        char[] characterArray = str.toCharArray();
        for (char chr : characterArray) {
            chrList.add(chr);
        }
    }

    public int find() {
        for (int i=0; i<chrList.size() -1;i++) {
            if (chrList.get(i) ==chrList.get(i+1))
                return i;
        }
        return -1;
    }
}
