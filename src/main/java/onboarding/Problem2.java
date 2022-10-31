package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int index = 0;
        while(true){
            int length = cryptogram.length();
            if(index >= length-1 || length < 2){
                break;
            }
            if(cryptogram.charAt(index) == cryptogram.charAt(index+1)){
                cryptogram = cryptogram.replace(cryptogram.substring(index, index+2),"");
                index = 0;
                continue;
            }

            index ++;
        }

        answer = cryptogram;
        return answer;
    }
}
