package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] bigAlpha1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        char[] bigAlpha2 = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N'};
        char[] smallAlpha1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};
        char[] smallAlpha2 = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n'};

        for(int i = 0; i < word.length(); i++) {
            char present = word.charAt(i);
            int presentNum = 0;
            String newAlpha = " ";

            if(present >= 'A' && present <= 'M') {
                for(int j = 0; j < bigAlpha1.length; j++) {
                    if(present == bigAlpha1[j]) {
                        presentNum = j;
                        break;
                    }
                }
                newAlpha = String.valueOf((char)(90-presentNum));
            }
            else if(present >= 'N' && present <= 'Z') {
                for(int j = 0; j < bigAlpha2.length; j++) {
                    if(present == bigAlpha2[j]) {
                        presentNum = j;
                        break;
                    }
                }
                newAlpha = String.valueOf((char)(65+presentNum));
            }
            else if(present >= 'a' && present <= 'm') {
                for(int j = 0; j < smallAlpha1.length; j++) {
                    if(present == smallAlpha1[j]) {
                        presentNum = j;
                        break;
                    }
                }
                newAlpha = String.valueOf((char)(122-presentNum));
            }
            else if(present >= 'n' && present <= 'z') {
                for(int j = 0; j < smallAlpha2.length; j++) {
                    if(present == smallAlpha2[j]) {
                        presentNum = j;
                        break;
                    }
                }
                newAlpha = String.valueOf((char)(97+presentNum));
            }

            answer = answer.concat(newAlpha);

        }
        return answer;
    }
}
