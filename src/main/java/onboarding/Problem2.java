package onboarding;

public class Problem2 {
    public static String remove_Duplicate(String str){
        char recentChar = 0;
        for(int i=0; i< str.length(); i++) {
            if (i != 0 && recentChar == str.charAt(i)) {
                str = str.substring(0, i - 1) + str.substring(i + 1);
                break;
            }
            recentChar = str.charAt(i);
        }
        return str;
    }

    public static Boolean check_Duplicate(String str){
        char recentChar = 0;
        for(int i=0; i <str.length(); i++){
            if(i != 0 && recentChar == str.charAt(i)){
                return true;
            }
            recentChar = str.charAt(i);
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (check_Duplicate(cryptogram)){
            cryptogram = remove_Duplicate(cryptogram);
        }
        answer = cryptogram;

        return answer;
    }

}
