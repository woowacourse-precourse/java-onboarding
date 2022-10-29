package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = deleteConsecutiveChar(cryptogram);
        return answer;
    }
    public static String deleteConsecutiveChar(String cryptogram)
    {
        int i=1;
        while (true)
        {
            if(i==cryptogram.length()||cryptogram.length()==0)
            {
                break;
            }
            if(cryptogram.charAt(i)==cryptogram.charAt(i-1)) {
                cryptogram = cryptogram.substring(0, i - 1) + cryptogram.substring(i+1);
                i = 1;
                continue;
            }
            i++;

        }
        return cryptogram;
    }
}
