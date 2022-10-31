package onboarding;

public class Problem4 {
    public static int setSum(char alphabet) {
        int sum;
        if (Character.isUpperCase(alphabet)) sum = 155;
        else if (Character.isLowerCase(alphabet)) sum = 219;
        else sum = 2 * alphabet;

        return sum;
    }
    public static char convertChar(char alphabet) {
        char result;
        int sum = setSum(alphabet);
        result = (char)(sum - (int)alphabet);

        return result;
    }
    public static String convertWord(String word) {
        char[] alphabetList = word.toCharArray();
        for (int i=0; i < alphabetList.length; i++) {
            alphabetList[i] = convertChar(alphabetList[i]);
        }
        String result = new String(alphabetList);

        return result;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
