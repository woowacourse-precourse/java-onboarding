package onboarding;
import java.util.Arrays;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] arrCapital = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        char[] arrCapitalReverse = { 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K',
                'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };
        char[] arrSmall = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] arrSmallReverse = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j',
                'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };

        char[] wordToArr = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            String a = "";
            char b = wordToArr[i];

            if (Character.isUpperCase(b)) {

                int index = Arrays.binarySearch(arrCapital, wordToArr[i]);
                System.out.print(arrCapitalReverse[index]);
            } else if (Character.isLowerCase(b)) {

                int index = Arrays.binarySearch(arrSmall, wordToArr[i]);

                System.out.print(arrSmallReverse[index]);
            } else {
                System.out.print(" ");
            }
        }

        return answer;
    }
}
