package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static ArrayList<String> changeNeedCrewEmails;
    private static ArrayList<List<String>> crews;
    private static HashMap<String, Integer> twoLetterNicknamesAndIds;

    public static List<String> solution(List<List<String>> forms) {
        initialize();
        validateForm(forms);
        AddAllCrews(forms);

        for (List<String> crew: forms) {
            if (validateCrew(crew)) {
                addDuplicateNickname(crew);
            }
        }

        return getAllChangeNeedCrewEmailByCrewId();
    }

    /**
     * 신청자 명부 검증
     * @param forms 폼
     */
    private static void validateForm(List<List<String>> forms) {
        int sizeForms = forms.size();
        if (sizeForms == 0 || sizeForms >= 10_000) {
            throw new RuntimeException("등록할 크루가 1명 이상 10,000명 이하여야 합니다.");
        }
    }

    /**
     * 크루 검증
     * @param crew 등록된 크루
     * @return 검증 결과 값
     */
    private static boolean validateCrew(List<String> crew) {
        int id = getCrewIdByCrew(crew);
        String email = crew.get(0);
        String nickname = crew.get(1);

        if(!Pattern.matches("^[.A-Za-z0-9_-]{1,9}+@email.com$", email)) {
            System.out.printf("%d번째 입력된 %s님의 이메일 주소는 허용되지 않는 형식입니다.\n", id, nickname);
            return false;
        }

        if (!Pattern.matches("^[가-힣]{1,19}$", nickname)) {
            System.out.printf("%d번째 입력된 %s님의 닉네임은 허용되지 않는 형식입니다.\n", id, nickname);
            return false;
        }

        return true;
    }

    /**
     * 중복된 크루 닉네임 추가
     * @param crew 크루 고유 번호
     */
    private static void addDuplicateNickname(List<String> crew) {
        int crewId = getCrewIdByCrew(crew);
        String nickname = crew.get(1);
        String[] twoLetterNicknames = createTwoLetterNicknames(nickname);
        ArrayList<String> internalDuplicateTwoLetterNicknames = new ArrayList<>();

        for (String twoLetter : twoLetterNicknames) {
            if (!internalDuplicateTwoLetterNicknames.contains(twoLetter) && existTwoLetterNickname(twoLetter)) {
                int ownerTwoLetterNickname = getCrewIdByTwoLetterNickname(twoLetter);

                addChangeNeedCrewEmailByCrewId(crewId);
                addChangeNeedCrewEmailByCrewId(ownerTwoLetterNickname);
            }

            internalDuplicateTwoLetterNicknames.add(nickname);
            putTwoLetterNicknameAndId(twoLetter, crewId);
        }
    }

    /**
     * 크루 닉네임을 한 글자씩 겹쳐 두 글자로 묶기
     * @param nickname 닉네임
     * @return 2글자씩 묶인 글자 집합을 반환
     */
    private static String[] createTwoLetterNicknames(String nickname) {
        String[] splitNicknames = nickname.split("");
        int lengthSplitNicknames = splitNicknames.length;
        String[] twoLetterNicknames = new String[lengthSplitNicknames - 1];

        for (int i = 1; i < lengthSplitNicknames; i++) {
            twoLetterNicknames[i - 1] = splitNicknames[i - 1] + splitNicknames[i];
        }

        return twoLetterNicknames;
    }

    /**
     * 분할된 크루 닉네임을 저장
     * @param twoLetterNickname 분할된 크루 닉네임의 일부
     * @param id 크루 고유 번호
     */
    private static void putTwoLetterNicknameAndId(String twoLetterNickname, int id) {
        if (!twoLetterNicknamesAndIds.containsKey(twoLetterNickname)) {
            twoLetterNicknamesAndIds.put(twoLetterNickname, id);
        }
    }

    /**
     * 분할된 크루 닉네임이 존재하는지 체크
     * @param twoLetterNickname 분할된 크루 닉네임
     * @return 분할된 크루 닉네임이 존재한지 여부
     */
    private static boolean existTwoLetterNickname(String twoLetterNickname) {
        return twoLetterNicknamesAndIds.containsKey(twoLetterNickname);
    }

    /**
     * 분할된 크루 닉네임을 통해 크루 고유 번호 검색
     * @param twoLetterNickname 분할된 크루 닉네임의 일부
     * @return 크루 고유 번호
     */
    private static int getCrewIdByTwoLetterNickname(String twoLetterNickname) {
        return twoLetterNicknamesAndIds.getOrDefault(twoLetterNickname, -1);
    }

    /**
     * 크루 아이디로 변경 필요 크루로 등록
     * @param crewId 크루 정보
     */
    private static void addChangeNeedCrewEmailByCrewId(int crewId) {
        List<String> crew = getCrewByCrewId(crewId);
        String email = crew.get(0);

        if (!changeNeedCrewEmails.contains(email)) {
            changeNeedCrewEmails.add(email);
        }
    }

    /**
     * 변경 필요 크루 모두 가져오기
     */
    private static ArrayList<String> getAllChangeNeedCrewEmailByCrewId() {
        return changeNeedCrewEmails;
    }

    /**
     * 크루 인덱싱
     * @param forms 크루 신청 데이터
     */
    private static void AddAllCrews(List<List<String>> forms) {
        crews.addAll(forms);
    }

    /**
     * 크루 데이터 검색
     * @param crewId 크루 고유 번호
     * @return 크루 데이터
     */
    private static List<String> getCrewByCrewId(int crewId) {
        return crews.get(crewId);
    }

    /**
     * 크루 정보로 크루 고유 번호 가져오기
     * @param crew 크루 정보
     * @return 크루 고유 번호
     */
    private static int getCrewIdByCrew(List<String> crew) {
        return crews.indexOf(crew);
    }

    /**
     * 초기화
     */
    private static void initialize() {
        changeNeedCrewEmails = new ArrayList<>();
        crews = new ArrayList<>();
        twoLetterNicknamesAndIds = new HashMap<>();
    }
}
