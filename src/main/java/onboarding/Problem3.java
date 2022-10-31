package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    private static Integer[] GAME_369_BOARD;

    public static int solution(int number) {
        return game369Board()[number];
    }

    public static int validCheck369(int num){
        List<String> numToString = List.of(String.valueOf(num).split("(?<=.)"));
        return (int) numToString.stream()
                .filter(value -> List.of("3", "6", "9").contains(value)).count();
    }

    public static Integer[] game369Board(){
        GAME_369_BOARD = new Integer[10001];
        for (int i = 3; i < 10001; i++) {
            markClapNumber(i);
        }
        return GAME_369_BOARD;
    }

    public static void markClapNumber(int num){
        GAME_369_BOARD[num] = GAME_369_BOARD[num-1]+validCheck369(num);
    }
}
