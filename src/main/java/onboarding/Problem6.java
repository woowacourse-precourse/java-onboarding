package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    /**
     * @param selfIndex : 0을 포함한 양의 정수(자신의 인덱스)
     * @param strList : 비교 하고싶은 list
     * @param substring : 포함 됐는지 확인하고 싶은 문자열
     * @return  substring이 strList내에서 자신의 인덱스를 제외하고 존재할 경우 해당 인덱스를 List에 담아 반환
     */
    private static Set<Integer> getIndexListOfContainSubString(int selfIndex, List<String> strList, String substring){
        Set<Integer> result = new HashSet<>();
        for(int i=0; strList.size() > i; i++){
            if(strList.get(i).contains(substring) && i != selfIndex){
                result.add(i);
            }
        }
        return result;
    }


}
