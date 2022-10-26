package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String decoder(String phar){
        String sub ="";
        String dec = phar;

        for(int i=0; i<phar.length()-1; i++ ){

                if(phar.charAt(i) == phar.charAt(i+1)){
                    sub += phar.charAt(i);
                    sub += phar.charAt(i+1);
                    dec.strip(sub);
                    sub ="";
                }
            }
        }
    }
}
