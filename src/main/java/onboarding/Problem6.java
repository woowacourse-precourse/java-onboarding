package onboarding;

import java.util.*;

/*
*   기능 목록
*   1. 조건을 만족하지 않는 닉네임을 resultset에 추가하는 기능
*   2. 크루들의 닉네임을 2글자 크기의 토큰으로 나누는 기능
*   3. 패턴이 나타난 이름을 forms 리스트에서 제외하고 result 리스트에 넣는 기능
*/
public class Problem6 {

    private static HashSet<String> resultset = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    static void getNameList(List<List<String>> forms) {
        for (List<String> splitedlist : forms) {
            if (splitedlist.get(0).length() < 1 || splitedlist.get(0).length() > 20) {
                resultset.add(splitedlist.get(1));
            }
        }
    }

    static List<String> getNameToken(List<String> names) {
        List<String> nameToken = new ArrayList<>();
        for (String name : names) {
            for (int j = 2; j <= name.length(); j++) {
                nameToken.add(name.substring(j - 2, j));
            }
        }
        return nameToken;
    }

    static void findDup(List<String> tokens, List<List<String>> forms, int idx) {
        for(int i = 0 ; i < forms.size() ; i++) {
            if(i != idx) {
                for (String token : tokens) {
                    if (forms.get(i).get(0).contains(token)) {
                        resultset.add(forms.get(i).get(1));
                    }
                }
            }
        }
    }
}