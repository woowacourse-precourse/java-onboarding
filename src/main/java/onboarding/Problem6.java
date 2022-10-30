package onboarding;

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
}
