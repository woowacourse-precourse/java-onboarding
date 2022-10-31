package onboarding;

import java.util.*;

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
        List<String> answer = checkNames(forms);

        return answer;
    }

    public static List<String> checkNames(List<List<String>> forms){

        Set<String> resultSet = new HashSet<>();


        // 교육생들의 이름을 담음
        List<String> names = new ArrayList<>();

        for (List<String> form : forms){
            names.add(form.get(1));
        }


        // 교육생들의 이름의 부분집합들을 구함
        Set<String> partNameSet = partNames(names);


        // 1. 이름의 부분집합들을 돌면서
        for (String partName : partNameSet){

            List<String> temp = new ArrayList<>();


            for (List<String> form : forms) {
                // 2. 만약 교육생들의 이름 중에 해당 부분집합이 포함되어 있다면 temp에 저장함
                if (form.get(1).contains(partName)){
                    temp.add(form.get(0));
                }
            }


            // 3. temp에 저장된 이메일이 2개 이상이면 중복이름을 가진 교육생들이 있다는 것이므로 해당 교육생들의 email을 resultSet에 담음
            if (temp.size() >= 2){
                resultSet.addAll(temp);
            }
        }

        // 이름에서 중복되는 부분 있는 교육생들을 리스트에 옮겨 담음
        List<String> result = new ArrayList<>(resultSet);

        // 오름차순으로 정렬
        Collections.sort(result);

        return result;




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

        return result;
    }
}
