package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        int check;
        while(true)
        {
            check = 0;
            answer = "";
            for(int i = 0; i < cryptogram.length() - 1; i++)
            {
                if (cryptogram.charAt(i) != cryptogram.charAt((i+1))) {
                    answer += cryptogram.charAt(i);
                }
                else {
                    check += 1;
                    i += 1;
                }
                if (i == cryptogram.length() - 2 && (cryptogram.charAt(i) != cryptogram.charAt((i+1))))
                {
                    answer += cryptogram.charAt(i + 1);
                }
            }
            if (check == 0) {
                break;
            }
            cryptogram = answer;
        }
        return answer;
    }
}
