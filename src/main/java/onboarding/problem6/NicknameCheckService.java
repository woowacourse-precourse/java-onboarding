package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class NicknameCheckService {

    // 같은 글자가 연속으로 포함된 경우 닉네임 사용 제한.
    public List<String> getDuplicateCrewEmail(List<Crew> crewList) {  // Map<email, nickname>
        List<String> results = new ArrayList<>();
        List<NicknameCasesBucket> casesBucket = getCasesBucket(getNicknames(crewList));
        // Map<String, Set<String>>

        for (Crew crew : crewList) {
            String currentNickname = crew.getNickname();
            String currentEmail = crew.getEmail();

            outer:
            for (NicknameCasesBucket bucket : casesBucket) {
                if (bucket.getNickname().equals(currentNickname)) {  // 현재 닉네임과 같은 경우를 찾지 않아도 됨.
                    continue;
                }

                Set<String> nicknameCases = bucket.getNicknameCases();
                for (String nicknameCase : nicknameCases) {
                    if (currentNickname.contains(nicknameCase) && !results.contains(nicknameCase)) {
                        results.add(currentEmail);
                        break outer;
                    }
                }
            }
        }

        Collections.sort(results);
        return results;
    }

    // 크루 리스트에서 닉네임만 추출
    private List<String> getNicknames(List<Crew> crewList) {
        return crewList.stream()
                .map(Crew::getNickname)
                .collect(Collectors.toList());
    }

    // 크루 닉네임 - 닉네임으로 나오는 경우의 수 <- 가 담긴 객체 리스트
    private List<NicknameCasesBucket> getCasesBucket(List<String> nicknames) {
        List<NicknameCasesBucket> results = new ArrayList<>();
        for (String nickname : nicknames) {
            results.add(new NicknameCasesBucket(nickname, getCases(nickname)));
        }

        return results;
    }

    // 유저 닉네임에 대한 경우의 수를 구하는 로직.
    private Set<String> getCases(String nickname) {
        Set<String> results = new HashSet<>();

        // 닉네임을 2글자씩 자른다.
        for (int idx = 0; idx < nickname.length() - 1; idx++) {
            String substring = nickname.substring(idx, idx + 2);
            results.add(substring);
        }

        return results;
    }
}
