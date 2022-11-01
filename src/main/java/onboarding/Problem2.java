package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {

        int currentLeng = cryptogram.length();

        String decrypted = decrypt(cryptogram);
        int decryptedLeng = decrypted.length();

        while (currentLeng != decryptedLeng) {
            currentLeng = decrypted.length();
            decrypted = decrypt(decrypted);
            decryptedLeng = decrypted.length();
        }

        return decrypted;
    }

    public static String decrypt(String cryptogram) {
        Queue<Character> q = new LinkedList<>();

        int decryptedTime = 0;

        String decrypted = "";

        for (int i = 0; i < cryptogram.length(); i++) {
            if (q.isEmpty()) {
                q.offer(cryptogram.charAt(i));
                continue;
            }
            if (q.peek() != cryptogram.charAt(i)) {
                if (q.size() > 1) {
                    while (!q.isEmpty()) {
                        q.poll();
                    }
                    decryptedTime++;
                    q.offer(cryptogram.charAt(i));
                    continue;
                }
                q.offer(cryptogram.charAt(i));
                decrypted += q.poll();
                continue;
            }
            if (q.peek() == cryptogram.charAt(i)) {
                q.offer(cryptogram.charAt(i));
            }
        }

        if (!q.isEmpty()) {
            if (q.size() > 1) {
                while (!q.isEmpty()) {
                    q.poll();
                }
                decryptedTime++;
            } else {
                decrypted += q.poll();
            }
        }

        if (decryptedTime == 0) {
            return cryptogram;
        }
        return decrypted;
    }
}