package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        List<String> result = new ArrayList<>();
        //맵으로  이메일, 이름 쌍들을 다넣는다
        //이중for문을 돌면서 중복되는것들을 찾아서 답안으로 바꿀 HashSet에 넣어둔다


        HashMap<String, String> map = new HashMap<>(); //이름, 이메일쌍으로 저장
        HashSet<String> overlap = new HashSet<>();


        String[] names = new String[forms.size()];
        int idx = 0;
        for (List<String> item : forms) {
            names[idx++] = item.get(1);           //이름 배열 따로 저장
            map.put(item.get(1), item.get(0)); //이름, 이메일쌍으로 저장
        }//이제 names 문자열의 배열을 2중for문으로 돌면서 중복되는 문자열들을 key로하는 value값을 overlap Set에 저장

        //이름 최대 20글자니까
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                char[] cArrA = names[i].toCharArray();
                char[] cArrB = names[j].toCharArray();

                for (int k = 0; k < cArrA.length - 1; k++) {
                    for (int l = 0; l < cArrB.length - 1; l++) {
                        if (cArrA[k] == cArrB[l] && cArrA[k + 1] == cArrB[l + 1]) {
                            overlap.add(map.get(names[i]));
                            overlap.add(map.get(names[j]));
                        }
                    }
                }
            }
        }

        for (String item : overlap) {
            result.add(item);
        }

        Collections.sort(result);


        return result;
    }

}