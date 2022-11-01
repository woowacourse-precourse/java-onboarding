package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(isInputValid(cryptogram)){
            return "";
        }
        return recursedRemove(cryptogram);
    }

    private static boolean isInputValid(String input){
        if(input == null || !input.toLowerCase().equals(input)){
            return false;
        }

        return input.length() > 0 && input.length() <= 1000;
    }

    private static boolean differentLetter(int i, char[] input, char[] result, int k){
        if(input[i] != input[i - 1]){
            result[k] = input[i - 1];
            return true;
        }
        return false;
    }

    private static int sameLetter(int i, char[] input, int inputSize){
        while (i < inputSize && input[i] == input[i - 1]) {
            i++;
        }

        return i;
    }

    private static String removeDuplicates(String input){

        char[] charInputArray = input.toCharArray();
        int inputSize = charInputArray.length;
        char[] result = new char[input.length()];


        int i, j = 0;

        for (i = 1; i < inputSize; i++) {
            if(differentLetter(i, charInputArray, result, j)){
                j++;
            }

            i = sameLetter(i, charInputArray, inputSize);

        }
        if(i != inputSize + 1){
            result[j++] = charInputArray[i - 1];
        }

        return new String(result).substring(0, j);
    }

    private static String recursedRemove(String input){
        String result = removeDuplicates(input);

        if(result.equals(input)){
            return result;
        }
        return recursedRemove(result);
    }
}
