package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!Character.isLetter(c)){
                answer += c;
                continue;
            }
            answer += treeFrog(c);
        }

        return answer;
    }
    public static char treeFrog(char c){
        int a = 'a';
        int A = 'A';
        int z = 'z';
        int Z = 'Z';

        if (Character.isLowerCase(c)){
            return (char) (z+a-c);
        }

        return (char) (Z+A-c);
    }
}
