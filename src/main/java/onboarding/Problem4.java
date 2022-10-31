package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] newword;
        HashMap<String, String> str = new HashMap<>();
        String[] alpabet = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        for (int i = 0; i < alpabet.length; i++) {
            str.put(Character.toString(65 + i), alpabet[i]);
        }
        newword = word.split("");
        for (int i = 0;i<newword.length;i++)
        {
            System.out.print(str.get(newword[i]));
        }

        return answer;
    }
}
