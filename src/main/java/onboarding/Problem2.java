package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        StringBuilder answer = new StringBuilder();
        answer.append(cryptogram.charAt(0));

        int i = 1;
        while(i<cryptogram.length()){
            int j = i;
            while(j<cryptogram.length() &&
                    answer.charAt(answer.length()-1)==cryptogram.charAt(j))
                j++;
            if(j==i) {
                answer.append(cryptogram.charAt(j));
                i++;
            }
            else {
                i = j;
                answer.deleteCharAt(answer.length()-1);
            }
        }
        return answer.toString();
    }
}
