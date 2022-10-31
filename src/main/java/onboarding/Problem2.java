package onboarding;

import java.util.Deque;

public class Problem2 {

    private static void checkCryptogramCharsUsingIdx(Deque<Character> decryptionCharStack, String cryptogram) {
        int idx = 0;

        while (idx < cryptogram.length()) {
            int newIdx = increaseIdxWhenCharEqual(decryptionCharStack.peekLast(), cryptogram, idx);
            idx = deleteOrAppendDecryption(decryptionCharStack, cryptogram, idx, newIdx);
        }
    }
    private static int increaseIdxWhenCharEqual(Character decryptionLastChar, String cryptogram, int idx) {

        while (decryptionLastChar != null && idx < cryptogram.length() && decryptionLastChar == cryptogram.charAt(idx)) {
            idx++;
        }

        return idx;
    }

    private static int deleteOrAppendDecryption(Deque<Character> decryptionCharStack, String cryptogram, int idx, int newIdx) {

        if (idx != newIdx) {
            deleteLastDecryptionChar(decryptionCharStack);
            return newIdx;
        }

        appendDecryptionChar(decryptionCharStack, cryptogram, newIdx);
        return idx + 1;
    }

    private static void deleteLastDecryptionChar(Deque<Character> decryptionCharStack) {
        decryptionCharStack.removeLast();
    }

    private static void appendDecryptionChar(Deque<Character> decryptionCharStack, String cryptogram, int newIdx) {
        if (newIdx < cryptogram.length()) {
            decryptionCharStack.addLast(cryptogram.charAt(newIdx));
        }
    }

    private static String decryptionCharStackToString(Deque<Character> decryptionCharStack) {
        StringBuilder sb = new StringBuilder();

        for (char ch : decryptionCharStack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    /**
     * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
     *
     * @param cryptogram 임의의 암호문 문자열
     * @return 해독한 문자열
     */
    public static String solution(String cryptogram) {
        Decrypt decrypt = new Decrypt();
        decrypt.setCryptogram(cryptogram);
        return decrypt.run();
    }
}

class Decrypt {
    private String cryptogram;

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String run() {
        String beforeDecode = "";
        String afterDecode = cryptogram;

        while (beforeDecode.length() != afterDecode.length()) {
            beforeDecode = afterDecode;

            afterDecode = decode(beforeDecode);
        }

        return afterDecode;
    }
}