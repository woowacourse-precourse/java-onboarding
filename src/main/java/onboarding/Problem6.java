package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        // TreeSet을 사용해 중복제거 , 오름차순 정렬 한다.
        TreeSet<String> tree = new TreeSet<>();


        for (int i = 0; i < forms.size(); i++) {
            for (int j = i+1; j < forms.size(); j++)
            // 조건문을 통해 이름이 같으면 tree에 이메일을 담아준다.
            {
                if ( test(forms.get(i).get(1), forms.get(j).get(1))) {
                    tree.add(forms.get(i).get(0));
                    tree.add(forms.get(j).get(0));
                }
            }
        }
        // list에 중복하고 정렬이된 tree를 담아준다.
        List<String> list = new ArrayList<>(tree);


        return list;

    }

    // boolean 타입을 사용해 앞에서 부터 2글자씩 slice해 중복을 체크해 equal이면 return true , 그게아니라면 return false
    static boolean test(String a, String b) {
        for (int i = 0; i < a.length()-1; i++) {
            for (int j = 0; j < b.length()-1; j++) {
                if (a.substring(i, i + 2).equals(b.substring(j, j + 2))) {
                    return true;
                }
            }
        }

        return false;
    }
}