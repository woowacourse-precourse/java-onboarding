package onboarding;

import java.util.*;

/* 기능 목록
 *
 * countPiece : form 전체에서 연속한 글자의 등장 횟수를 셈
 * getInvalidEmail : 닉네임에서 연속한 글자가 같은 교육생의 이메일 리스트를 반환
 * hasSamePiece : 닉네임의 연속한 글자가 여러 번 등장하는지 확인
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> pieceNum = countPiece(forms);
        List<String> answer = getInvalidUserEmail(forms, pieceNum);

        Collections.sort(answer);

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

    private static List<String> getInvalidUserEmail(List<List<String>> forms, Map<String, Integer> pieceNum) {
        List<String> invalidEmailList = new ArrayList<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            if(hasSamePiece(name, pieceNum))
                invalidEmailList.add(email);
        }

        return invalidEmailList;
    }

    private static boolean hasSamePiece(String name, Map<String, Integer> pieceNum) {
        for(int i = 1; i < name.length(); i++) {
            String piece = name.substring(i-1, i+1);
            if(pieceNum.getOrDefault(piece, 0) > 1)
                return true;
        }
        return false;
    }
}
