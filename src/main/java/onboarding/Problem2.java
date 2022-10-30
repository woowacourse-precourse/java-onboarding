package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = translate(cryptogram);
        return answer;
    }

    public static boolean checkDup(String cryptogram){
        for(int i=0; i<cryptogram.length()-1; i++){
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1))
                return true;
        }
        return false;
    }

    public static String translate(String cryptogram){
        String result="";
        int count=0;
        while(checkDup(cryptogram)){

        }
        return result;
    }
}
