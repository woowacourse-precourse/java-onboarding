package onboarding;

public class Problem4 {
    public static boolean isAlpha(char ch){
        if(ch >= 'a' && ch <= 'z') return true;
        if(ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
    public static boolean isUpperCharacter(char ch){
        if(ch >= 'A' && ch <= 'Z') return true;
        else return false;
    }

    public static char ConvertCharacter(char ch){
        int diff = 0;
        if(isUpperCharacter(ch)) {
            diff = ch - 'A';
            ch = (char)('A' + (25 - diff));
        }
        else{
            diff = ch - 'a';
            ch = (char)('a' + (25 - diff));
        }
        return ch;
    }
    public static String solution(String word) {
        StringBuilder result = new StringBuilder("");

        for(int i=0; i<word.length(); i++){
            char current = word.charAt(i);
            if(!isAlpha(current)) result.append(current);
            else result.append(ConvertCharacter(current));
        }
        return result.toString();
    }

}
