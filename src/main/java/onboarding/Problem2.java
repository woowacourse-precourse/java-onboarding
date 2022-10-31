package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int i;
        int cnt = 0;
        boolean hasDuplicatedChar;

        do {
            hasDuplicatedChar = false;
            answer = "";

            for (i = 0; i < cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    cnt++;
                    hasDuplicatedChar = true;
                } else if (cnt > 0) {
                    cnt = 0;
                } else {
                    answer = answer + cryptogram.charAt(i);
                }
            }

            if (cnt == 0) {
                answer = answer + cryptogram.charAt(i);
            }

            cryptogram = answer;

        } while (hasDuplicatedChar);

        return answer;
    }
}
