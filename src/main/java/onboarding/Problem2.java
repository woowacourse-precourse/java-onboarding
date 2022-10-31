package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String removeDuplicates(String cryptogram){
        char[] cryptoArray = cryptogram.toCharArray();

        char prev_char = 0;
        int cnt = 0;
        for(char c:cryptoArray){
            if(prev_char!=c){
                cryptoArray[cnt++] = c;
                prev_char = c;
            }else{
                cnt--;
            }
        }
        return new String(cryptoArray).substring(0,cnt);
    }
}
