package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        char duplicatedChar;
        String pattern;
        int iter = 0;

        while(iter<answer.length()-1){
            duplicatedChar = answer.charAt(iter);
            if(duplicatedChar == answer.charAt(iter+1)){
                pattern = duplicatedChar+"{2,}";
                answer=answer.replaceAll(pattern,"");
                iter = 0;
            }else{
                iter++;
            }
        }

        return answer;
    }
}
