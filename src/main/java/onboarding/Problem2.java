package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] chars = cryptogram.toCharArray();
        for(int i =0;i<cryptogram.length()-1;i++){
            if(chars[i]==chars[i+1]){
                cryptogram=cryptogram.substring(0,i)+cryptogram.substring(i+2);
                System.out.println(cryptogram);
                break;
            }
        }
        String answer = "answer";
        return answer;
    }
}
