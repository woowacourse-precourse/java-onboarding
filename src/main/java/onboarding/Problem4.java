package onboarding;

public class Problem4 {

    StringBuilder result = new StringBuilder();
    public static String solution(String word) {
        Problem4 p4 = new Problem4();
        p4.iterate(word);
        return p4.result.toString();
    }

    private void iterate(String word) {
        for(char c : word.toCharArray()){
            if(c > 'a' && c < 'z') result.append((char)('a' + 'z' - c));
            else if(c > 'A' && c < 'Z') result.append((char)('A' + 'Z' - c));
            else result.append(" ");
        }
    }
}
