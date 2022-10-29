package onboarding;

public class Problem4 {

    //문자열의 문자가 알파벳인지 아닌지 확인
    public static boolean isAlphabet(char c){
        if((c-'a'>=0) & (c-'a'<26))
            return true;
        else if((c-'A'>=0) & (c-'Z' <26))
            return true;
        else
            return false;
    }

    //알파벳을 반대로 바꾸는 method
    public static Character changeAlphabet(char c){
        char result = c;

        for(int i = 65; i<91; i++) {
            if (c == (char)(i)) {
                result = (char) (155 - i);
            }
        }
        for(int i =97; i<123; i++){
            if(c == (char)(i)){
                result = (char)(219-i);
            }
        }
        return result;
    }

    public static char[] changeString(String s){
        char[] chars = s.toCharArray();
        for(int i = 0; i<s.length(); i++){
            if(isAlphabet(chars[i]))
                chars[i] = changeAlphabet(chars[i]);
        }
        return chars;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
