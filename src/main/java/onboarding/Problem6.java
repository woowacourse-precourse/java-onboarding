package onboarding;

import java.util.*;

/*
*   기능 목록
*   1. 조건을 만족하는 닉네임을 가진 크루만 모아놓은 리스트를 만드는 기능
*   2. 모든 이름에서 패턴과 일치하는 부분이 있는지 탐색하는 기능
*   3. 패턴이 나타난 이름을 forms 리스트에서 제외하고 result 리스트에 넣는 기능
*/
public class Problem6 {

    private static HashSet<String> resultset = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    static List<String> getNameList(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (List<String> splitedlist : forms) {
            if (splitedlist.get(1).length() > 1 && splitedlist.get(1).length() < 20) {
                list.add(splitedlist.get(1));
            }
            else {
                resultset.add(splitedlist.get(2));
            }
        }
        return list;
    }
}