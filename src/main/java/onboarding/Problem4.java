package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseAlphabet(word);
    }

    public static String reverseAlphabet(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if('A' <= c && c <= 'M'){
                sb.append((char)('Z' - (c  - 'A')));
                continue;
            }
            if('N' <= c && c <= 'Z'){
                sb.append((char)('A'+('Z' - c)));
                continue;
            }
            if('a' <= c && c <= 'm'){
                sb.append((char)('z' - (c  - 'a')));
                continue;
            }
            if('n' <= c && c <= 'z'){
                sb.append((char)('a'+('z' - c)));
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
