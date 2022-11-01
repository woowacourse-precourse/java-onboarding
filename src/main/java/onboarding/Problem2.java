package onboarding;


public class Problem2 {

    public static String solution(String cryptogram) {
        int i = 0;
        while(i < cryptogram.length()-1){
            if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) {
                i++;
                continue;
            }
            //인접한 문자가 중복된다면, 이후 문자도 같은 문자인지
            int endIdx = i + 1;
            while (endIdx < cryptogram.length() - 1) {
                if (cryptogram.charAt(endIdx) != cryptogram.charAt(endIdx + 1)) {
                    break;
                }
                endIdx++;
            }

            cryptogram = cryptogram.replace(cryptogram.substring(i, endIdx + 1), "");
            if (i != 0){
                i--;
            }
        }
        return cryptogram;
    }

}
