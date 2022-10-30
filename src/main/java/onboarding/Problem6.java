package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    /**
     * @param userList : 2차원 리스트[[이메일(혹은 다른 정보), 닉네임]]
     * @param length : 자연수
     * @return userList의 닉네임의 길이가 length이상인 2차원 리스트를 반환
     */
    private static List<List<String>> getUserListByNicknameLength(List<List<String>> userList, int length){
        List<List<String>> result = userList.stream()
                .filter(user -> user.get(1).length() >= length)
                .collect(Collectors.toList());
        return result;
    }
    /**
     * @param str : 문자열
     * @param length : 자연수
     * @return 문자열의 순서를 바꾸지 않고 length만큼 자른 모든 경우에 수를 List<String> 타입으로 반환
     * 예) str = "이펙티브", length = 2 -> [이펙, 펙티, 티브]
     * 예) str = "이펙티브", length = 3 -> [이펙티, 펙티브]
     */
    private static List<String> splitStringInAllCases(String str, int length){
        List<String> result = new ArrayList<>();
        int count = 0;
        for(int i = length; str.length() >= i; i++){
            result.add(str.substring(count, i));
            count++;
        }
        return result;
    }

}
