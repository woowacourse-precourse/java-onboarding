package onboarding;

import java.util.ArrayList;
import java.util.List;

// 단어를 한글자씩 Character 객체로 변환한 리스트를 반환하는 객체
public class CharSpliter<T> {
    private List<Character> chars = new ArrayList<>();

    public List<Character> getChars(T data) {

        // 제네릭 타입의 data를 String으로 변환
        String strData = String.valueOf(data);

        // String data에서 한글자씩 Character 형태로 자름
        for (int i = 0; i < strData.length(); i++)
            chars.add(strData.charAt(i));

        return chars;
    }
}
