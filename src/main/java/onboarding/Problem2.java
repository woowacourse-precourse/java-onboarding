package onboarding;

public class Problem2 {
    private static String answer;

    public static String solution(String cryptogram) {
        char nowChar;
        char nextChar;
        StringBuilder answer = new StringBuilder();
        boolean duplicate = false;
        for(int i=0; i<cryptogram.length();i++){
            nowChar = cryptogram.charAt(i);
            if(i == cryptogram.length() -1 ) nextChar = '\0';
            else                             nextChar = cryptogram.charAt(i+1);
            if(nowChar != nextChar){
                if(!duplicate){
                    answer.append(nowChar);
                }
                else{
                    duplicate = false;
                }
            }
            else{
                duplicate = true;
            }
        }
        if(answer.toString().equals(cryptogram)) return answer.toString();
        else                          return solution(answer.toString());
    }
    
}
