package onboarding.problem2;

import java.util.Iterator;
import java.util.LinkedList;

import static onboarding.problem2.Returner.returnLinkedList;

public class Tester {

    public static String testingDuplicate(String cryptogram) {

        String result = "";

        LinkedList<String> linkedList = new LinkedList<>();

        // 문자열 저장을 순회
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            char d = cryptogram.charAt(i - 1);

            // 중복 여부 == true시 삭제
            if (c == d) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.deleteCharAt(c);
                stringBuilder.deleteCharAt(d);

            }

            // 삭제후 남은 문자 저장
            for (String s : linkedList) {
                linkedList.add(s);
            }

            // linkedList에 저장된 값 문자열로 전달
            Iterator<String> stringIterator = returnLinkedList(linkedList);

        }

        return result;
    }
}



