package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(isUpperCase(currentChar)){
                //알파벳 대문자일 경우 변환

            }
            //알파벳 소문자일 경우 변환

            //공백일 경우 유지
        }

        return answer;
    }

    private static boolean isUpperCase(char a){
        if('A'<=a && a<='Z') {
            return true;
        }else{
            return false;
        }
    }

    private static boolean isLowerCase(char a){
        if('a'<=a && a<='z') {
            return true;
        }else{
            return false;
        }
    }

    private static char changeUpperCase(char currentChar){
        int upperCaseConstant = 'A' + 'Z';
        int conversion = upperCaseConstant - currentChar;
        char newChar = (char)conversion;
        return newChar;
    }
    private static char changeLowerCase(char currentChar){
        int lowerCaseConstant = 'a' + 'z';
        int conversion = lowerCaseConstant - currentChar;
        char newChar = (char)conversion;
        return newChar;
    }

}
