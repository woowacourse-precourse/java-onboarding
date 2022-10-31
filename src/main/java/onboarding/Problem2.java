package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        while (cryptogram.length() > 1) {
            String result = "";
            result = removeDuplicateCharacter(cryptogram);
            if (cryptogram.equals(result)){
                break;
            }
            cryptogram = result;
        }

        answer = cryptogram;
        return answer;
    }

    public static String removeDuplicateCharacter(String cryptogram) {
        String result = "";

        for (int index = 0; index < cryptogram.length() -1; index++) {

            if (cryptogram.charAt(index) != cryptogram.charAt(index + 1)) {
                result += cryptogram.charAt(index);
            }
            else if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
                index += countDuplicateCharacter(cryptogram, index);
            }
            if ( (index + 1) == (cryptogram.length() - 1) ) {
                result += cryptogram.charAt(index + 1);
            }
        }
        return result;
    }

    public static int countDuplicateCharacter(String cryptogram, int startindex){
        int count = 0;
        int lastindex = startindex +1;

        if(lastindex == cryptogram.length()-1){
            return 1;
        }
        while (cryptogram.charAt(startindex) == cryptogram.charAt(lastindex)){
            count++;
            lastindex++;
        }
        return count;
    }
}
