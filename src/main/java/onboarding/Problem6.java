package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> dupList = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> userInfo = forms.get(i);
            dupList = getDuplicatedNameUsersEmailList(dupList, forms, userInfo, i + 1);
        }

        List<String> answer = new ArrayList<>(dupList);

        Collections.sort(answer);

        return answer;
    }

    /**
     * 
     * @param dupList    반환받을 HashSet 객체
     * @param forms      닉네임과 이메일 정보를 담은 2차원 List
     * @param userInfo   다른 목록과 비교할 유저 대상
     * @param formsIndex forms에서 비교할 대상의 index
     * @return
     */
    private static HashSet<String> getDuplicatedNameUsersEmailList(HashSet<String> dupList,
            List<List<String>> forms,
            List<String> userInfo,
            int formsIndex) {

        if (formsIndex >= forms.size()) {
            return dupList;
        }

        List<String> compareList = forms.get(formsIndex);
        String compareEmail = compareList.get(0);
        String compareName = compareList.get(1);

        String userEmail = userInfo.get(0);
        String userName = userInfo.get(1);

        if (isDuplicated(userName, compareName)) {
            dupList.add(userEmail);
            dupList.add(compareEmail);
        }

        return getDuplicatedNameUsersEmailList(dupList, forms, userInfo, formsIndex + 1);
    }

    /**
     * 입력받은 문자열 2개를 비교해 2자 이상 중복되었는 판별함
     * 
     * @param name
     * @param compareName
     * @return {@code} boolean} 2자이상 중복 여부
     */
    private static boolean isDuplicated(String name, String compareName) {

        for (int s = 0; s < name.length() - 1; s++) {
            String slicedName = name.substring(s, s + 2);

            if (compareName.indexOf(slicedName) > -1) {
                return true;
            }
        }

        return false;
    }
}
