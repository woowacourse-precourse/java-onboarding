package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while(answer.length()!=0){
            String newAnswer = getNewString(answer,checkDuplicateChar(answer));
            if(newAnswer.length()==answer.length())break;
            answer = newAnswer;
        }

        return answer;
    }
    public static boolean[] checkDuplicateChar(String str){
        boolean[] isDuplicated = new boolean[str.length()];

        char currentChar = str.charAt(0);

        for(int i=1; i<str.length(); i++){
            char nextChar = str.charAt(i);
            if(nextChar==currentChar){
                isDuplicated[i] = true;
                isDuplicated[i-1] = true;
            }
            currentChar = nextChar;
        }

        return isDuplicated;
    }
    public static String getNewString(String cryptogram, boolean[] isDuplicate){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<isDuplicate.length; i++)
            if(!isDuplicate[i])
                sb.append(cryptogram.charAt(i));

        return sb.toString();
    }
}
