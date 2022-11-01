package onboarding;

import java.util.*;

/*
*   기능 목록
*   1. 조건을 만족하는 닉네임을 가진 크루만 모아놓은 리스트를 만드는 기능
*   2. 크루들의 닉네임을 2글자 크기의 토큰으로 나누는 기능
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

    static List<List<String>> getNameToken(List<String> names) {
        List<List<String>> nameToken = new ArrayList<>();
        for (String name : names) {
            List<String> tokenList = new ArrayList<>();
            for (int j = 2; j <= name.length(); j++) {
                tokenList.add(name.substring(j - 2, j));
            }
            nameToken.add(tokenList);
        }
        return nameToken;
    }
}