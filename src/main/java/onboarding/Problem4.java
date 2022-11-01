package onboarding;

public class Problem4 {
    private static int A_CODE = 65;
    private static int Z_CODE = 90;
    private static int a_CODE = 97;
    private static int z_CODE = 122;


    public static String solution(String word) {
        return convertString(word);
    }

    private static Character getUpperCase(int code) {
        return (char)(Z_CODE - (code - A_CODE));
    }

    private static Character getLowerCase(int code) {
        return (char)(z_CODE - (code - a_CODE));
    }

    private static String convertString(String word) {
        StringBuilder answer = new StringBuilder();

        for (char aChar : word.toCharArray()) {

            int code = (int) aChar;

            if (code >= A_CODE && code <= Z_CODE) {
                answer.append(getUpperCase(code));

            } else if (code >= a_CODE && code <= z_CODE) {

                answer.append(getLowerCase(code));
            } else {

                answer.append(aChar);
            }
        }
        return answer.toString();
    }
}
