package onboarding;

public class Problem4 {
    public static String solution(String word) {

        String newWord = "";

        for (int i=0; i<word.length(); i++) {
            if(word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                char convertChar = (char)(90 - word.charAt(i) % 65);
                newWord = newWord.concat(Character.toString(convertChar));
            }

            if(word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                char convertChar = (char)(122 - word.charAt(i) % 97);
                newWord = newWord.concat(Character.toString(convertChar));
            }

            if(word.charAt(i) == 32) {
                newWord = newWord.concat(" ");
            }
        }

        return newWord;
    }

    public static void main(String[] args) {
        String result = solution("I love you");
        System.out.println("result = " + result);

    }
}
