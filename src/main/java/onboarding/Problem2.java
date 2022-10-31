package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        return recursedRemove(cryptogram);
    }

    private static boolean isInputValid(String input){
        if(input == null || !input.toLowerCase().equals(input)){
            return false;
        }

        return input.length() > 0 && input.length() <= 1000;
    }
    private static String removeDuplicates(String input){

        char[] charInputArray = input.toCharArray();
        int inputSize = charInputArray.length;
        char[] result = new char[input.length()];


        int i, j = 0;

        for (i = 1; i < inputSize; i++) {
            if (charInputArray[i] != charInputArray[i - 1]) {
                result[j++] = charInputArray[i - 1];
            }
            else {
                for(;i < inputSize && charInputArray[i] == charInputArray[i - 1]; i++);
            }

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
