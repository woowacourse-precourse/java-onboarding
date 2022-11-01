package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (hasDup((answer))){
            System.out.println(answer);
            answer = removeDup(answer);
        }
        return answer;
    }

    public static boolean hasDup(String str){
        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == str.charAt(i + 1)) return true;
        }
        return false;
    }

    public static String removeDup(String str){
        String dupRemovedString = "";
        for (int i = 0; i < str.length(); i++){
            if (i > 0 && str.charAt(i) == str.charAt(i-1)) continue;;
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) continue;

            dupRemovedString += str.charAt(i);
        }

        return dupRemovedString;
    }

}
