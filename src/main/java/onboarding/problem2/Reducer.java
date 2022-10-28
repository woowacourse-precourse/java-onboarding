package onboarding.problem2;

import java.util.Collections;
import java.util.HashSet;
import static onboarding.problem2.Converter.convertToArray;

// 중복 제거 기능
public class Reducer {


    // 제거 기능
    // 일급 컬렉션 만들어보기
    // 알바 끝나고 Collections.singleton() 알아보능
    public static HashSet<String> reduceDuplicate(char[] cryptogram) {
        HashSet reducer = new HashSet<>(Collections.
                singleton((convertToArray(String.valueOf(cryptogram)))));
        return reducer;
    }
}
