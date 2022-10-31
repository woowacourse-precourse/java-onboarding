package onboarding;

public class Problem2 {
    public static String delSame(String cryptogram, int i) {
        char tar = cryptogram.charAt(i);
        if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)){
            int start = i;
            int end = i;

            if (cryptogram.length() == 2){
                return "";
            }

            while (tar == cryptogram.charAt(i)){
                end += 1;
                i += 1;
            }

            cryptogram = cryptogram.substring(0, start) + cryptogram.substring(end);
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        int i = 0;
        while (i < cryptogram.length() - 1) {
            int temp = cryptogram.length();
            cryptogram = delSame(cryptogram, i);

            if(temp != cryptogram.length()){
                if (i > 0){
                    i -= 1;
                }
            } else {
                i += 1;
            }
        }
        answer = cryptogram;
        return answer;
    }
}
