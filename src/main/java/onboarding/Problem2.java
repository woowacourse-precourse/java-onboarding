package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        boolean bool = true;
        while (bool){
            bool = false;
            for(int i=0;i<cryptogram.length()-1;i++){
                if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                    if(i+2<cryptogram.length()){
                        cryptogram = cryptogram.substring(0, i)+cryptogram.substring(i+2);
                        bool = true;
                    }else{
                        cryptogram = cryptogram.substring(0,i);
                    }
                }
            }
            answer = cryptogram;
        }

        return answer;
    }
}
