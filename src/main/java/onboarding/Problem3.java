package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    private static final int[] GAME_369_BOARD = new int[10001];
    public static int solution(int number) {
        game369Board();
        int answer = numberOnGame369Board(number);
        return answer;
    }
    public static int numberOnGame369Board(int number){
        return GAME_369_BOARD[number];
    }
    public static String[] numToString(int num){
        return String.valueOf(num).split("(?<=.)");
    }
    public static int validCheck369(int num){
        List<String> numToString = List.of(numToString(num));
        return numToString.stream()
                          .filter(value->List.of("3","6","9").contains(value))
                          .collect(Collectors.toList())
                          .size();
    }
    public static void markClapNumber(int num){
        GAME_369_BOARD[num] = GAME_369_BOARD[num-1]+validCheck369(num);
    }
    public static void game369Board(){
        for (int i = 3; i < 10001; i++) {
            markClapNumber(i);
        }
    }
}
