package onboarding;

public class Problem2 {

    private static final String SPECIFIC_VALUE = "-";

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String[] strArray = answer.split("");

        while (isDuplication(strArray)){
            answer = convertString(strArray);
            strArray = answer.split("");
        }
        return answer;
    }
    private static boolean isDuplication(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            String firstString = array[i];
            String nextString = array[i + 1];

            if(firstString.equals(nextString)) {
                return true;
            }
        }
        return false;
    }

    private static void convertSpecificValue(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            String firstString = array[i];
            String nextString = array[i + 1];

            if(firstString.equals(nextString)) {
                array[i] = SPECIFIC_VALUE;
                array[i + 1] = SPECIFIC_VALUE;
            }
        }
    }

    private static String convertString(String[] array) {
        convertSpecificValue(array);
        return String.join("",array).replace(SPECIFIC_VALUE,"");
    }

}
