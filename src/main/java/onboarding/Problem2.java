package onboarding;

public class Problem2 {
    private static String removeDuplicatedChar(String str){
        String modifiedStr = "";
        str+= " ";

        boolean isDuplicate = false;
        for(int i = 0 ; i < str.length() - 1; i++){
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (!isDuplicate)
                    modifiedStr += str.charAt(i);
                isDuplicate = false;
            } else {
                isDuplicate = true;
            }
        }
        return modifiedStr;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
