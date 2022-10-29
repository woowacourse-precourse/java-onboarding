package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> pieceNum = countPiece(forms);

        return answer;
    }

    private static Map<String, Integer> countPiece(List<List<String>> forms) {
        Map<String, Integer> pieceNum = new HashMap<>();

        for(List<String> form : forms) {
            String name = form.get(1);

            for(int i = 1; i < name.length(); i++) {
                String piece = name.substring(i-1, i+1);

                pieceNum.put(piece, pieceNum.getOrDefault(piece, 0) + 1);
            }
        }

        return pieceNum;
    }
}
