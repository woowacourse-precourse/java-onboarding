package onboarding;

public class Problem4 {
    //대소문자 최대 최솟값 아스키코드
    private static int maxUpperAscii = 90, minUpperAscii = 65;
    private static int maxLowerAscii = 122, minLowerAscii = 97;

    public static String solution(String word) {
        String answer = "";
        answer = cvtString(word);
        return answer;
    }
    //청개구리 사전 변환 함수
    private static String cvtString(String word){
        String result="";
        for(int i=0; i<word.length(); i++){
            char charWord = word.charAt(i);
            if((charWord<=90 && charWord>=65) || (charWord<=122 && charWord>=97)) {
                if (Character.isUpperCase(charWord)) {
                    result += (char) (maxUpperAscii - ((charWord) - minUpperAscii));
                } else if (Character.isLowerCase(charWord)) {
                    result += (char) (maxLowerAscii - ((charWord) - minLowerAscii));
                } else {
                    result += " ";
                }
            }
            else{
                result += charWord;
            }
        }
        return result;
    }
}