package onboarding;


public class Problem4 {

    public static char getTreeFrogChar(char character) {
        int number = 0;
        if (Character.isUpperCase(character)) {
            number = 155 - (int) character;
        } else if (Character.isLowerCase(character)) {
            number = 219 - (int) character;
        }
        char result = (char) number;
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        char[] array = word.toCharArray();
        for (int j = 0; j < array.length; j++) {
            array[j] = getTreeFrogChar(array[j]);
            int a = (int) array[j];
            System.out.println(a);
            answer += Character.toString(array[j]);
        }

        return answer.replaceAll("\\u0000", " ");
    }
}
