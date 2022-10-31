package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean flag = false;
        while(!flag){
            flag = true;
            String temp = "";
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    i++;
                    flag = false;
                }
                else{
                    temp += cryptogram.charAt(i);
                }
            }
            if(cryptogram.length() != 0 && cryptogram.charAt(cryptogram.length()-2) != cryptogram.charAt(cryptogram.length()-1)){
                temp += cryptogram.charAt(cryptogram.length()-1);
            }
            cryptogram = temp;
        }
        answer = cryptogram;
        return answer;
    }
}
