package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        sb.append(cryptogram);
        int i = 1;
        while(i < sb.length()){
            if(sb.charAt(i) != sb.charAt(i - 1)){
                i++;
                continue;
            }
            sb.delete(i-1, i+1);
            i = 1;
        }
        answer = sb.toString();
        return answer;
    }
}
