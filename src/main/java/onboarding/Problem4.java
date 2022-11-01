package onboarding;

class Dictionary {

    static char getReverseCharacter(char character) {
        int ascii = character;
        int reverseAscii = getReverseByAscii(ascii);
        char reverseCharacter = (char) reverseAscii;
        return reverseCharacter;
    }

    static int getReverseByAscii(int ascii) {
        int reverseAscii = ascii;
        if (ascii >= 65 && ascii <= 90) {
            reverseAscii = 90 - (ascii - 65);
        }
        if (ascii >= 97 && ascii <= 122) {
            reverseAscii = 122 - (ascii - 97);
        }
        return reverseAscii;
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++) {
            int a = 25;
            char mydivword = word.charAt(i);


            if (mydivword >= 65 && mydivword <= 90) {

                for(char c='A'; c<='Z'; c++) {
                    if (mydivword == c) break;
                    a -= 2;
                }
            } else if (mydivword <= 122&& mydivword >= 97 ){

                for(char c='a'; c<='z'; c++) {
                    if (mydivword == c) break;
                    a -= 2;
                }
            } else {
                answer += mydivword;
                continue;
            }

            mydivword += a;
            answer += mydivword;
        }

        return answer;
    }
}
