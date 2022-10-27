package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return removeDuplication(cryptogram);
    }

    private static String removeDuplication(String str){
        char recentChar = 0;
        boolean isRemoved = false;
        for (int i=0; i< str.length(); i++){
            if(i != 0 && recentChar == str.charAt(i)){
                str = str.substring(0,i-1) + str.substring(i+1);
                isRemoved = true;
                break;
            }
            recentChar = str.charAt(i);
        }

        if (isRemoved)
            str = removeDuplication(str);

        return str;
    }
}
