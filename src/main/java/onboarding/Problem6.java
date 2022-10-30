package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<List<String>> userDoubleList = getUserListByNicknameLength(forms, 2);  //두글자 이상의 닉네임을 가진 user
        List<String> userList = getFlatList(userDoubleList);        // 1차원 배열로
        List<String> nicknameList = getElementsByKorean(userList);  //한글 닉네임만 추출
        List<String> splitNicknameList = new ArrayList<>();     //닉네임 문자열의 모든 분할 케이스
        Set<Integer> userIndexSet = new HashSet<>();            //중복된 부분문자열을 포함하고있는 유저 닉네임의 인덱스

        for(int i=0; userDoubleList.size() > i; i++){
            splitNicknameList = splitStringInAllCases(userDoubleList.get(i).get(1),2);
            for(int j=0; splitNicknameList.size() > j; j++){
                userIndexSet.addAll(getIndexListOfContainSubString(i, nicknameList, splitNicknameList.get(j)));
            }
        }

        Iterator<Integer> iter = userIndexSet.iterator();

        while(iter.hasNext()){
            answer.add(userDoubleList.get(iter.next()).get(0));
        }
        Collections.sort(answer);   //오름차순 정렬
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

    /**
     * @param doubleList : 2차원 문자열 리스트
     * @return 2차원 리스트를 평탄화해 1차원 리스트로 합쳐 반환
     */
    private static List<String> getFlatList(List<List<String>> doubleList){
        return doubleList.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    /**
     * @param strList : 문자열 리스트
     * @return 한국어만 존재하는 요소를 List에서 추출해 반환
     */
    private static List<String> getElementsByKorean(List<String> strList){
        List<String> result = new ArrayList<>();
        result = strList.stream().filter(list -> list.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")).collect(Collectors.toList());

        return result;
    }
}
