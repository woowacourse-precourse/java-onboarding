package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static String solution(String cryptogram) {
        return removeDuplicate(cryptogram);
    }

    public static String removeDuplicate(String cryptogram) {
        List<String> newCryptogram = new ArrayList<>();
        String pre = "";
        for (String alphabet : cryptogram.split("")) {
            if (newCryptogram.isEmpty()) {
                newCryptogram.add(alphabet);
                continue;
            }
            if (alphabet.equals(newCryptogram.get(newCryptogram.size() - 1))) {
                newCryptogram.remove(newCryptogram.size() - 1);
                pre = alphabet;
                continue;
            }
            if (pre.equals(alphabet)) {
                continue;
            }
            pre = alphabet;
            newCryptogram.add(alphabet);
        }
        return String.join("", newCryptogram);
    }
}
