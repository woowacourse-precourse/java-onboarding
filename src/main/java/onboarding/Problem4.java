package onboarding;

public class Problem4 {
    //대문자, 소문자 각 range에서 reverse character를 반환하는 함수
    private static char reverseTransferChar(char ascii){
        if((int)'A' <= ascii && ascii <= (int)'Z')
            ascii = (char)((int)'A'+ (int)'Z'- (int)ascii);
        else if((int)'a' <= ascii && ascii <= (int)'z')
            ascii = (char)((int)'a'+ (int)'z'- (int)ascii);
        return ascii;
    }
    //단어를 규칙에 따라 전체 변환하는 함수
    private static String wordTransfer(String word){
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++)
        {
            char ascii = word.charAt(i);
            ascii = reverseTransferChar(ascii);
            answer.append(ascii);
        }
        return answer.toString();
    }
    public static String solution(String word) {
        return wordTransfer(word);
    }
}
