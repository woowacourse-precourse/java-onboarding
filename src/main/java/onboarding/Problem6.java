package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) partNames
 *          : 교육생들의 이름에서 길이 2이상인 이름의 부분집합을 뽑아낸다.
 *          2) checkNames
 *          : partNames에서 반환한 교육생들의 이름 부분집합에서 중복되는 멤버의 수가 2이상일 경우, 중복된 이름을 가진 것으로 간주하고 중복 멤버 리스트에 추가한다.
 *            Set을 이용하여 중복 추가를 방지하고, return 전에 List에 옮겨 담는다.
 *            List에 옮겨 담은 후 오름차순으로 정렬하여 반환한다.
 *
 *
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }


    public static Set<String> partNames(List<String> names){

        Set<String> result = new HashSet<>();

        for (String name : names){
            //이름이 인접하기 위해서는 이름이 두 글자 이상이어야 함
            if (name.length() > 1){

                int len = name.length();

                for (int i = 2; i <= len; i++) {
                    for (int j = 0; i + j <= len; j++){
                        String part = name.substring(j, i+j);
                        result.add(part);
                    }
                }
            }
        }

        System.out.println(result);

        return result;
    }
}
