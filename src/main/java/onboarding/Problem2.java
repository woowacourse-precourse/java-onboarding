package onboarding;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        boolean isDup = true;

        while (isDup) {
            String rmDupStr = removeDup(answer);
            if(answer.equals(rmDupStr))
                isDup = false;
            else
                answer = rmDupStr;
        }

        return answer;
    }

    private static String removeDup(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        char prev = 0;

        StringBuilder sb = new StringBuilder();
        boolean isDup = false;

        for(char c : chars){

            if(cnt == 0)
                prev = c;
            else if(prev != c){
                if(!isDup) {
                    sb.append(prev);
                }
                else{
                    isDup = false;
                }
            }
            else
                isDup = true;

            if(cnt == chars.length-1 && prev!= c)
                sb.append(c);

            prev = c;
            cnt++;
        }

        return sb.toString();
    }
}