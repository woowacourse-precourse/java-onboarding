package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String decoded = "";
        List<String> stringList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        for (int i = 0; i < stringList.size() - 1; i++) {
            if (stringList.get(i).equals(stringList.get(i + 1))) {
                stringList.remove(i);
                stringList.remove(i);
                i = -1;
            }
        }
        for (String string : stringList) {
            decoded += string;
        }
        return decoded;
    }


}
