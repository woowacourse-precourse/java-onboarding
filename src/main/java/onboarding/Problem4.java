package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length(); ++i){
            if(word.charAt(i) == ' ')
                sb.append(word.charAt(i));
            else
                sb.append(word.charAt(i) < 97 ? (char)(155 - word.charAt(i)) : (char)(219 - word.charAt(i)));
        }

        return sb.toString();
    }
}
