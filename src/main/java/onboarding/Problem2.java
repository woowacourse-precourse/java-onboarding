package onboarding;

public class Problem2 {

    public static boolean validCheck(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        if (cryptogram.length() > 1000 || cryptogram.length() < 1) {
            return false;
        }
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    public static String deduplication(String cryptogram){
        boolean deleteFlag = true;
        StringBuilder word = new StringBuilder();
        char[] charArray = cryptogram.toCharArray();
        for(int i=1; i<charArray.length; i++){
            word.append(charArray[i]);
            if(charArray[i] == charArray[i-1]){
                word.delete(i-1, i);
                deleteFlag = false;
            }
        }
        if(deleteFlag){
            return word.toString();
        }
        return "0";
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
