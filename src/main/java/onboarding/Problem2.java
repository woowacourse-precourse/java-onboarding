package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {

    public static String solution(String cryptogram) {
        return deleteDuplication(cryptogram);
    }

    /**
     * 연속하는 중복 문자 삭제
     * @param cryptogram
     * @return String
     */
    private static String deleteDuplication(String cryptogram) {
        List<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        while(isDuplication(cryptogramList)) {
            for (int i = 0; i < cryptogramList.size() - 1; i++) {
                if (cryptogramList.get(i).equals(cryptogramList.get(i + 1))) {
                    cryptogramList.remove(i);
                    cryptogramList.remove(i);
                }
            }
        }
        return String.join("",cryptogramList);
    }

    /**
     * 연속하는 중복 문자 존재하는지 확인
     * @param cryptogramList
     * @return 중복 문자 있으면 true / 없으면 false
     */
    private static boolean isDuplication(List<String> cryptogramList) {
        for (int i = 0; i < cryptogramList.size() - 1; i++) {
            if (cryptogramList.get(i).equals(cryptogramList.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

}
