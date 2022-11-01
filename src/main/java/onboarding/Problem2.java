package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Boolean bool = true;

            while(bool) {
                for (int i = 0; i < cryptogram.length() - 1; i++) {
                    char oneoftwo = cryptogram.charAt(i);
                    char twooftwo = cryptogram.charAt(i + 1);
                    //int originallength = cryptogram.length();
                   // int count = 0;
                    if (oneoftwo == twooftwo) {
                        if (i == 0) {
                            String Cryptogram = cryptogram.substring(i + 2);
                            cryptogram = Cryptogram;
                        } else if ((i + 1) == cryptogram.length()) {
                            String Cryptogram = cryptogram.substring(0, i);
                            cryptogram = Cryptogram;
                        } else {
                            String onehalf = cryptogram.substring(0, i);
                            String twohalf = cryptogram.substring(i + 2);
                            String crypto = onehalf + twohalf;
                            cryptogram = crypto;
                        }
                        //count += 1
                    }
                    if((i+1) == cryptogram.length());{
                        //count = 0;
                        bool = false;
                    }

                }
            }


    answer = cryptogram;
        return answer;
    }
}
