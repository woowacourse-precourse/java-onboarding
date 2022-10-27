package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseAlphabet(word);
    }

    public static String reverseAlphabet(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if('A' < c && c < 'M'){
                c = (char)('Z' - (c  - 'A'));
            }else if('N' < c && c < 'Z'){
                c = (char)('A'+('Z' - c));
            }else if('a' < c && c < 'm'){
                c = (char)('z' - (c  - 'a'));
            }else if('n' < c && c < 'z'){
                c = (char)('a'+('z' - c));
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
