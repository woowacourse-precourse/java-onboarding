package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true) {
            int cryptogramLen = cryptogram.length();
            if(cryptogramLen == 0)
                break;

            int count = 1;
            for(int i = 0; i < cryptogramLen - 1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    if(i == 0) {
                        cryptogram = cryptogram.substring(i+2, cryptogramLen);
                    }
                    else {
                        String a = cryptogram.substring(0, i);
                        String b = cryptogram.substring(i+2, cryptogramLen);
                        cryptogram = a.concat(b);
                    }
                    break;
                }
                count++;
            }
            if(count == cryptogramLen)
                break;
        }
        answer = cryptogram;

        return answer;
    }
}
