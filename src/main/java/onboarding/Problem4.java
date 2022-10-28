package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] dictionary = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T',	'S', 'R', 'Q', 'P',	'O', 'N', 'M',
                'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                int num = Character.toUpperCase(ch);
                char convert = dictionary[num - 65];
                if (Character.isUpperCase(ch)) {
                    sb.append(convert);
                }

                else {
                    sb.append(Character.toLowerCase(convert));
                }
            }

            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
