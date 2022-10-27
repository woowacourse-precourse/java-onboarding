package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    public static int[] game369Board(){
        return new int[10001];
    }
    public static int numberOnGame369Board(int number){
        return game369Board()[number];
    }
    public static String[] numToString(int num){
        return String.valueOf(num).split("(?<=.)");
    }
    public static boolean validCheck369(int num){
        CharSequence numToString = (CharSequence) List.of(numToString(num));
        if("3".contains(numToString) || "6".contains(numToString) || "9".contains(numToString)){
            return true;
        }
        return false;
    }

}
