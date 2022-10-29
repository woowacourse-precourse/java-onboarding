package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        /* [요구] 연속하는 중복 문자들을 삭제 후 리턴 */
        return removeDuplicate(cryptogram);
    }

    // 연속하는 중복 문자들을 삭제하는 메서드
    public static String removeDuplicate(String cryptogram) {
        List<String> newCryptogram = new ArrayList<>();
        String pre = "";
        for (String s: cryptogram.split("")){
            if (newCryptogram.isEmpty()) {
                newCryptogram.add(s);
                continue;
            }
            if (s.equals(newCryptogram.get(newCryptogram.size()-1))) {
                newCryptogram.remove(newCryptogram.size()-1);
                pre = s;
                continue;
            }
            if (pre.equals(s)) {
                continue;
            }
            pre = s;
            newCryptogram.add(s);
        }
        return String.join("", newCryptogram);
    }
}
