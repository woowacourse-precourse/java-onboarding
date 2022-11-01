package onboarding;

public class Problem4 {
    private static final char CONVERSION(char x){
        int result=x;
        if(x>='a'&&x<='z') result='a'+'z'-x;
        if(x>='A'&&x<='Z') result='A'+'Z'-x;
        return (char)result;
    }

    public static String solution(String word) {
        if(input_exception(word)) return "input error";

        return getWord(word);
    }

    private static String getWord(String word){
        char[] char_word=word.toCharArray();
        String result="";
        for(int i=0;i<word.length();i++){
            result+=CONVERSION(char_word[i]);
        }
        return result;
    }

    private static boolean input_exception(String input){
        //true is 'exception excution'
        if(input.length()<1||input.length()>1000) return true;

        return false;
    }
}
