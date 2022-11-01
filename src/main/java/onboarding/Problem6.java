package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static Set<String> answer = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        answer.clear();
    }

    private static Set<String> getDistinctNicknamePieces(String nickname) {
        Set<String> nicknamePieces = new HashSet<>();
        IntStream.range(0, nickname.length() - 1)
                .forEach(startPieceIndex ->
                        nicknamePieces.addAll(createSubNicknamePieces(nickname, startPieceIndex))
                );

        return nicknamePieces;
    }

    private static Set<String> createSubNicknamePieces(String nickname, int startPieceIndex) {
        return IntStream.range(startPieceIndex + 2, nickname.length() + 1)
                .mapToObj(endPieceIndex -> nickname.substring(startPieceIndex, endPieceIndex))
                .collect(Collectors.toSet());
    }

}
