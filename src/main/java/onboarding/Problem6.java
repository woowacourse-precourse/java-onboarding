package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void checkDuplicate(String nickname, int emailIndex, Map<String, Integer> pieceStorage,
                                       boolean[] emailsDuplicateCheck, List<String> duplicatedEmails,
                                       String[] emails) {
        List<String> currentPieces = new ArrayList<>();

        for(int i = 1; i < nickname.length(); i++) {
            String piece = nickname.substring(i -1, i + 1);
            //만약 중복한다면,
            if(pieceStorage.containsKey(piece)) {
                saveDuplicatedEmail(emailIndex, piece, duplicatedEmails, emails, emailsDuplicateCheck, pieceStorage);
                //중복되면 검사 끝
                return;
                //중복하지 않다면, 리스트에 추가
            } else {
                currentPieces.add(piece);
            }
        }
        //이 이메일이 중복이 아님이 확인되면, pieceStorage 에 저장해둔 piece 추가
        savePiece(emailIndex, currentPieces, pieceStorage);
    }

    public static void savePiece(int emailIndex, List<String> currentPieces, Map<String, Integer> pieceStorage) {
        for(String piece : currentPieces) {
            pieceStorage.put(piece, emailIndex);
        }
    }
    public static void saveDuplicatedEmail(int emailIndex, String piece,
                                           List<String> duplicatedEmails, String[] emails
            , boolean[] emailsDuplicateCheck,
                                           Map<String, Integer> pieceStorage) {
        //현재 검사하고 있는 닉네임의 이메일을 추가
        duplicatedEmails.add(emails[emailIndex]);
        //중복 추가를 막기 위해 기록
        emailsDuplicateCheck[emailIndex] = true;
        //현재 검사하고 있는 것과 중복되는 피스를 가지고 있는 닉네임의 이메일을 추가
        int duplicatedEmailIndex = pieceStorage.get(piece);
        //기 등록 이메일을 중복 이메일 리트스에 추가하지 않을 때만 추가
        if(!emailsDuplicateCheck[duplicatedEmailIndex]) {
            duplicatedEmails.add(emails[duplicatedEmailIndex]);
            emailsDuplicateCheck[duplicatedEmailIndex] = true;
        }
    }
}
