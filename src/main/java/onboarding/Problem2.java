package onboarding;

/*
중복 문자 제거
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<cryptogram.length();i++){
                if(i+1<cryptogram.length() &&cryptogram.charAt(i)==cryptogram.charAt(i+1))
                    continue;
                if(i-1>=0 && cryptogram.charAt(i-1)==cryptogram.charAt(i))
                    continue;
                sb.append(cryptogram.charAt(i));
            }
            if(sb.toString().equals(cryptogram)) break;
            cryptogram=sb.toString();
        }
        answer=cryptogram;
        return answer;
    }
}
