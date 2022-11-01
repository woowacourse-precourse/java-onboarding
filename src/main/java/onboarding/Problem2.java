package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean isDuplicated = true;
        String code = cryptogram;
        while(isDuplicated){
            char bf = 0;
            int i = 0;
            boolean isChanged = false;
            String left, right;
            for(char c : code.toCharArray()){
                if(c == bf) {
                    left = code.substring(0, i - 1);
                    right = code.substring(i + 1);
                    code = left+right;
                    isChanged = true;
                    break;
                }
                i++;
                bf = c;
            }
            isDuplicated = isChanged;
        }
        answer = code;
        return answer;

    }
}
