package onboarding;

import java.util.*;

/** 구현 기능 목록
 * 1. 닉네임을 두글자씩 쪼개어 리스트로 저장
 * 2. 쪼갠 닉네임과 이메일을 해시맵으로 저장
 * 3. 쪼갠 닉네임들을 합쳐서 리스트로 저장
 * 4. 쪼갠 닉네임 부분을 갖고 있는 사람 찾기
 * 5. 중복 닉네임을 가진 사람의 이메일을 정렬하여 반환
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = findTotalEmailWithPart(forms);
        return answer;
    }

    private static List<String> splitNickname(String nickname) {
        List<String> nicknameParts = new ArrayList<>();
        for (int i=0; i < nickname.length()-1; i++) {
            nicknameParts.add(nickname.substring(i, i+2));
        }
        return nicknameParts;
    }

    private static HashMap<String, List<String>> createHashMap(List<List<String>> forms) {
        HashMap<String, List<String>> emailAndNicknameParts = new HashMap<>();
        for (int i=0; i < forms.size(); i++) {
            List<String> nicknameParts = splitNickname(forms.get(i).get(1));
            emailAndNicknameParts.put(forms.get(i).get(0), nicknameParts);
        }
        return emailAndNicknameParts;
    }

    private static List<String> createNicknamePartList(HashMap<String, List<String>> emailAndNicknameParts) {
        List<String> nicknameParts = new ArrayList<>();
        for (List<String> nicknamePart : emailAndNicknameParts.values()) {
            nicknameParts.removeAll(nicknamePart);
            nicknameParts.addAll(nicknamePart);
        }
        return nicknameParts;
    }

    private static List<String> findEmailWithPart(String nicknamePart, HashMap<String, List<String>> emailAndNicknameParts) {
        List<String> emailWithPart = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : emailAndNicknameParts.entrySet()) {
            if (entry.getValue().contains(nicknamePart))
                emailWithPart.add(entry.getKey());
        }
        return emailWithPart;
    }

    private static List<String> findTotalEmailWithPart(List<List<String>> forms) {
        HashMap<String, List<String>> emailAndNicknameParts = createHashMap(forms);
        List<String> nicknameParts = createNicknamePartList(emailAndNicknameParts);
        List<String> totalEmailWithPart = new ArrayList<>();
        for (String nicknamePart : nicknameParts) {
            List<String> emailWithPart = findEmailWithPart(nicknamePart, emailAndNicknameParts);
            if (emailWithPart.size() >= 2) {
                totalEmailWithPart.removeAll(emailWithPart);
                totalEmailWithPart.addAll(emailWithPart);
            }
        }
        totalEmailWithPart.sort(Comparator.naturalOrder());
        return totalEmailWithPart;
    }

    private static List<String> sortEmail(List<String> emails) {
        List<String> sortedEmails = new ArrayList<>();
        for (String email : emails) {
            String[] id = email.split("@");
            sortedEmails.add(id[0]);
        }
        sortedEmails.sort(Comparator.naturalOrder());
        return addDomainToEmail(sortedEmails);
    }

    private static List<String> addDomainToEmail(List<String> emails) {
        List<String> emailWithDomain = new ArrayList<>();
        for (String email : emails) {
            email += "@email.com";
            emailWithDomain.add(email);
        }
        return emailWithDomain;
    }
}
