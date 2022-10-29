package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for(char c : word.toCharArray()){
            if(65 <= c && c<= 90){
                c = (char)(90-c+65);
            } else if (97 <= c && c <= 122) {
                c = (char)(122-c+97);
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
