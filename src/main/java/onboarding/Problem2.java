package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean flag = false;
        do {
            int l = cryptogram.length();
            flag = false;
            answer = "";
            for (int i = 0; i < l - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    flag = true;
                    i+=1;
                    continue;
                }
                answer += cryptogram.charAt(i);
            }
            if(l>1 && cryptogram.charAt(l-1) != cryptogram.charAt(l-2)){
                answer += cryptogram.charAt(l-1);
            }
            cryptogram = answer;
        }while(flag);
        return answer;
    }
}
