package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String left = "";
        String right  = "";
        String ans = "";
        int index = 0;

        while(index < cryptogram.length()-1) {
            char ch = cryptogram.charAt(index);
            char ch_next = cryptogram.charAt(index + 1);
            if(ch == ch_next) {
                left = cryptogram.substring(0,index);
                right = cryptogram.substring(index+2);

                cryptogram = left + right;
                index--;
                continue;
            }

            index++;
        }
        return cryptogram;
    }
}
