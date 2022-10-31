package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
       return removeDuplicateChar(cryptogram);
    }

    public static String removeDuplicateChar(String value) {
        StringBuilder result = new StringBuilder(value);

        for(int i = 1; i < result.length(); i++){
            if(result.charAt(i-1) == result.charAt(i)){
                result.deleteCharAt(i);
                if (result.length() > 1){
                    while(result.charAt(i-1) == result.charAt(i)){
                        result.deleteCharAt(i);
                    }
                }
                result.deleteCharAt(i-1);
                i = 0;
            }
        }

        return result.toString();
    }
}
