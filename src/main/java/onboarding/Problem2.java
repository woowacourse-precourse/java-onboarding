package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (true) {
            int originLength = cryptogram.length();

            cryptogram = removeDuplicated(cryptogram);

            if (cryptogram.length() == originLength) {
                // if string's length is same after remove duplicated characters, then break while loop
                break;
            }
        }

        answer = cryptogram;
        return answer;
    }

    /**
     * remove continuously duplicated character and return modified string
     * @param crypto
     * @return
     */
    static String removeDuplicated(String crypto) {
        char[] chArray = crypto.toCharArray();
        int idx = 0;
        char prev = '\0';

        for (char ch : chArray) {
            if (prev != ch) {
                chArray[idx] = ch;
                idx++;
                prev = ch;
            } else {
                idx--;
            }
        }

        return new String(chArray).substring(0, idx);
    }
}
