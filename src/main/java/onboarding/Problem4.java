package onboarding;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
    public static String solution(String word) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        for(int i=0;i<word.length();i++){
            char alphabet = word.charAt(i);

            if(alphabet>=65 && alphabet<=90){
                int change = 90 - (int)alphabet + 65;
                alphabet = (char) change;
            }else if(alphabet>=97 && alphabet<=122){
                int change = 122 - (int)alphabet + 97;
                alphabet = (char) change;
            }
            result.append(alphabet);
        }
        return result.toString();
    }
}
