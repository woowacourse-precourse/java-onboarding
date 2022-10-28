package onboarding;

import java.util.*;

/**
 * 1. n 단위로 문자열 slicing 해주는 기능
 * 2. 두 개의 문자열에서 서로 2글자 연속으로 중복되는게 있는지 boolean 값으로 알려주는 기능
 * 3. 매개변수 forms에서 같은 글자가 연속적으로 포함된 닉네임을 가진 이메일 리스트를 반환하는 기능
 * 4. 이메일이 담긴 리스트를 오름차순으로 정렬하는 기능
 * */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> result = new ArrayList<>();

        return result;
    }

    public static boolean compareBothNickname(String curNickname, String compareNickname) {
        List<String> slicingCurNick = sliceStringNTime(curNickname, 2);
        List<String> stringsCompareNic = sliceStringNTime(compareNickname, 2);

        return slicingCurNick.stream().anyMatch(stringsCompareNic::contains);
    }

    public static List<String> sliceStringNTime(String target, int n) {
        ArrayList<String> result = new ArrayList<>();

        if (n < 1 || target.length() < n) {
            return result;
        }

        for (int i = 0; i < target.length() - (n - 1); i++) {
            result.add(target.substring(i, i + n));
        }
        return result;
    }
}
