package onboarding;

public class Problem4 {
    private static char reverseTransferChar(char ascii){
        if((int)'A' <= ascii && ascii <= (int)'Z')
            ascii = (char)((int)'A'+ (int)'Z'- (int)ascii);
        else if((int)'a' <= ascii && ascii <= (int)'z')
            ascii = (char)((int)'a'+ (int)'z'- (int)ascii);
        return ascii;
    }

    public static String solution(String word) {
        return "";
    }
}
