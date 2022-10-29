package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < 26; i++){
                String token = "";
                token += (char)('a' + i);
                token += (char)('a' + i);
                String res = answer.replace(token, "");
                if(res.length() != answer.length()) flag = true;
                answer = res;
            }
        }
        return answer;
    }
}
