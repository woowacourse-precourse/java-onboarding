package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String str = "";
        int start = 0;
        int i = 1;

        while(i < cryptogram.length()) {
            if(start >= i)
                break;

            if(cryptogram.charAt(start) != cryptogram.charAt(i)) {
                if(str.equals("")) {
                    start = i;

                    i += 1;
                }
                else
                {
                    cryptogram = cryptogram.replace(str, "");

                    start = 0;

                    i = 1;

                    str = "";
                }
            }
            else
            {
                str = cryptogram.substring(start, i + 1);

                if(cryptogram.equals(str))
                    cryptogram = "";

                i += 1;
            }

            answer = cryptogram;
        }
        return answer;
    }
}