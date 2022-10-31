package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
       String answer = "";
        boolean flag = true;

        while(flag) {
            int cnt = 0;
            answer = "";
            for (int i = 0; i < cryptogram.length(); i++) {
                if (i+1 < cryptogram.length() && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    i ++;
                    cnt++;
                } else {
                    answer += cryptogram.charAt(i);
                }
            }
            if(cnt == 0){
                return answer;
            }
            cryptogram = answer;
        }
        return answer;
    }
}
