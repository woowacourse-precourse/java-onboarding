package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuilder cryptoBuilder = new StringBuilder(cryptogram);
        boolean loop = true;

        while(loop){
            loop = false;
            for(int i=0; i<cryptoBuilder.length()-1; i++){
                if(cryptoBuilder.charAt(i) == cryptoBuilder.charAt(i+1)){
                    cryptoBuilder.delete(i, i+2);
                    loop = true;
                    break;
                }
            }
        }

        answer = cryptoBuilder.toString();

        return answer;
    }
}
