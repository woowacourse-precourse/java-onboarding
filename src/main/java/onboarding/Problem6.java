package onboarding;

import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
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
