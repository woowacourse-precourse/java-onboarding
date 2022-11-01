package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int FORM_EMAIL_INDEX = 0;
    private static final int FORM_NICKNAME_INDEX = 1;

    private static Map<String, Integer> nicknamePiecesCount = new HashMap<>();
    private static Set<String> answer = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        answer.clear();
        nicknamePiecesCount.clear();

        initNicknamePiecesCount(forms);

        List<String> distinctAnswer = new ArrayList<>(answer);
        Collections.sort(distinctAnswer);

        return distinctAnswer;
    }

    private static void initNicknamePiecesCount(List<List<String>> forms) {
        for (List<String> userForm : forms) {
            String nickname = userForm.get(FORM_NICKNAME_INDEX);
            reflectNicknamePiecesCount(nickname);
        }
    }

    private static void reflectNicknamePiecesCount(String nickname) {
        for (String nicknamePiece : getDistinctNicknamePieces(nickname)) {
            nicknamePiecesCount.put(
                    nicknamePiece,
                    nicknamePiecesCount.getOrDefault(nicknamePiece, 0) + 1
            );
        }
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
