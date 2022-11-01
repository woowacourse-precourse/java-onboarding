package onboarding;

public class Problem4 {
    private static char transUpper(char c){
        return (char)('Z' - (c - 'A'));
    }
    private static char transLower(char c){
        return (char)('z' - (c - 'a'));
    }

    private static char translate(char c){
        if(Character.isUpperCase(c))
            return transUpper(c);
        return transLower(c);
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(Character.isAlphabetic(c)){
                answer.append(translate(c));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
