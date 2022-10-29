package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int i = 0;
        while(i < cryptogram.length()-1){
            if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) {
                i++;
                continue;
            }
            cryptogram = cryptogram.replace(cryptogram.substring(i, i + 2), "");
            i--;
        }
        return cryptogram;
    }

}
