package onboarding;

import java.util.Deque;

public class Problem2 {

    /**
     * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
     *
     * @param cryptogram 임의의 암호문 문자열
     * @return 해독한 문자열
     */
    public static String solution(String cryptogram) {
        Decrypt decrypt = new Decrypt();
        return decrypt.run(cryptogram);
    }
}

class Decrypt {

    public String run(String cryptogram) {
        String beforeDecode = "";
        String afterDecode = cryptogram;

        while (beforeDecode.length() != afterDecode.length()) {
            beforeDecode = afterDecode;

            afterDecode = decode(beforeDecode);
        }

        return afterDecode;
    }

    private String decode(String beforeDecode) {
        int head = 0;
        int tail = 1;
        StringBuilder sb = new StringBuilder();

        while (head < beforeDecode.length()) {
            char headChar = beforeDecode.charAt(head);
            tail = increaseTailIfSameChar(beforeDecode, tail, headChar);
            appendCharIfAnotherChar(sb, head, tail, headChar);
            head = tail;
            tail++;
        }

        return sb.toString();
    }

    private int increaseTailIfSameChar(String beforeDecode, int tail, char nowChar) {
        while (tail < beforeDecode.length() && nowChar == beforeDecode.charAt(tail)) {
            tail++;
        }
        return tail;
    }

    private void appendCharIfAnotherChar(StringBuilder sb, int head, int tail, char headChar) {
        if (head + 1 == tail) {
            sb.append(headChar);
        }
    }
}