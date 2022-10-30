package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        ArrayList<String> wordList = new ArrayList<>();
        char[] charArr = word.toCharArray();

        for (int i=0;i<charArr.length;i++) {
            char c = charArr[i];

            if (c=='\0') {
                break;
            }
            else {
                int asc = (int) c;
                char trans=0;
                if ((asc>=65)&&(asc<=90)) {
                    trans = (char)reverseUpper(asc);
                }
                else if ((asc>=97)&&(asc<=122)) {
                    trans = (char)reverseLower(asc);
                }

                if (trans!=0)
                    charArr[i] = trans;
            }
        }
        answer = String.valueOf(charArr);

        return answer;
    }

    public static int reverseUpper(int asc) {
        return 155-asc;
    }

    // 소문자일 때
    public static int reverseLower(int asc) {
        return 219-asc;
    }
}
