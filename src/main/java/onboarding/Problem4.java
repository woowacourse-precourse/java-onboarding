package onboarding;

public class Problem4 {

    public static char dict(char ch){
        if(ch >= 65 && ch <= 90){
            return (char)((65+90)-ch);
        }else if(ch >= 97 && ch <= 122){
            return (char)((97+122)-ch);
        }else{
            return (char)(32);
        }
    }

    public static String solution(String word) {
        char[] chars = word.toCharArray();
        for(int i=0; i<chars.length; i++){
            char w = dict(chars[i]);
            chars[i] = w;
        }
        String reversed = new String(chars);
        return reversed;
    }
}
