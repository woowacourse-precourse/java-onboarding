package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static ArrayList<List<String>> crews = new ArrayList<>();
    private static HashMap<String, Integer> twoLetterNicknamesAndIds = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {


        return forms.get(0);
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
     * 분할된 크루 닉네임을 통해 크루 고유 번호 검색
     * @param twoLetterNickname 분할된 크루 닉네임의 일부
     * @return 크루 고유 번호
     */
    private static int getIdByTwoLetterNickname(String twoLetterNickname) {
        return twoLetterNicknamesAndIds.getOrDefault(twoLetterNickname, -1);
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
     * @param id 크루 고유 번호
     * @return 크루 데이터
     */
    private static List<String> getCrewById(int id) {
        return crews.get(id);
    }
}
