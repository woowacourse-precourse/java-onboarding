package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int pos = 0;

        for(char c : word.toCharArray())
            System.out.println(reverse_char(c));

        return answer;
    }

    private static char reverse_char(char c){
        int pos = 0;

        if(Character.isLowerCase(c)){
            pos = c - 97;
            return (char)(122 - pos);
        }

        else{
            pos = c - 65;
            return (char)(90 - pos);
        }
    }

    public static void main(String[] args) {
        solution("abcd");
    }
}
