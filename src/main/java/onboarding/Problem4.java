package onboarding;

public class Problem4 {
    private static int maxUpperAscii = 90;
    private static int minUpperAscii = 65;
    private static int maxLowerAscii = 122;
    private static int minLowerAscii = 97;
    public static String solution(String word) {
        String answer = "";
        answer = cvtString(word);
        return answer;
    }
    private static String cvtString(String word){
        String result="";
        for(int i=0; i<word.length(); i++){
            char charWord = word.charAt(i);
            if(Character.isUpperCase(charWord)) {
                result += (char) (maxUpperAscii -((charWord)-minUpperAscii));
            }
            else if(Character.isLowerCase(charWord)){
                result += (char) (maxLowerAscii -((charWord)-minLowerAscii));
            }
            else{
                result +=" ";
            }
        }
        return result;
    }
}