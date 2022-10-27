package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        game369BoardLoop();
        int answer = numberOnGame369Board(number);
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
        List<String> numToString = List.of(numToString(num));
        return numToString.contains("3")||numToString.contains("6")||numToString.contains("9");
    }
    public static void game369BoardLoop(){
        for (int i = 3; i < 10001; i++) {
            markClapNumber(i);
        }
    }
    public static void markClapNumber(int num){
        if(validCheck369(num)){
            game369Board()[num] += game369Board()[num-1]+1;
        }
    }
}
