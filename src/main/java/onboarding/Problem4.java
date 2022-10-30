package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != ' '){
                int charValue = (int)word.charAt(i);
                if(charValue <= 90){
                    char ch = (char)(90 - (charValue - 65));
                    sb.append(ch);
                }
                else{
                    char ch = (char)(122 - (charValue - 97));
                    sb.append(ch);
                }
            }
            else{
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
