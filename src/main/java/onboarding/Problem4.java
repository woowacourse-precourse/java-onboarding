package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(!checkValidation(word)){
            return null;
        }
        answer = convertStringByDict(word);
        return answer;
    }

    private static boolean checkValidation(String word){
        if(1 <= word.length() || word.length()<=1000){
            return true;
        }
        return false;
    }

    private static String convertStringByDict(String word){
        StringBuffer value = new StringBuffer(word);
        for(int i=0; i<value.length(); i++){
            if(needConvert(value.charAt(i))){
                char convetedChar = getConvertedChar(value.charAt(i));
                value.setCharAt(i,convetedChar);
            }
        }
        return value.toString();
    }

    private static boolean needConvert(char ch){
        if('a'< ch && ch < 'z'){
            return true;
        }
        if('A'< ch && ch < 'Z'){
            return true;
        }
        return false;
    }

    private static char getConvertedChar(char ch){
        if('a'< ch && ch < 'z'){
            return (char)('a'+('z' - ch));
        }
        if('A'< ch && ch < 'Z'){
            return (char)('A'+('Z' - ch));
        }
        return ' ';
    }
}
