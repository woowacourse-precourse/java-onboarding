package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // forms 를 이용한 이름배열 nameList
        List<String> nameList = makeNameList(forms);

        // nameList 를 이용하여 만들수 있는 두글자들의 배열 nameTemp
        List<List<String>> nameTemp = makeTempList(nameList);

        // nameTemp 를 이용한 중복문자가 있는 forms 의 index 들의 배열 findIndexArr
        Integer[] findIndexArr = findIndex(nameTemp).toArray(new Integer[findIndex(nameTemp).size()]);

        // for 반복문을 돌며 forms 에서 index 값을 이용하여 email 값을 찾아 answer.add()
        for (Integer integer : findIndexArr) {
            answer.add(forms.get(integer).get(0));
        }

        // answer 의 값을 정렬.
        Collections.sort(answer);


        return answer;
    }
    
    // forms 에서 이름만을 모아 list를 반환.
    static List<String> makeNameList(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).length() > 1) {
                list.add(forms.get(i).get(1));
            }
        }
        return list;
    }
    
    // 이름만을 뽑은 list 인자를 받아 만들수 있는 2글자의 값들을 반환.
    static List<List<String>> makeTempList(List<String> nameList) {
        List<List<String>> nameTemp = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 2; j <= nameList.get(i).length(); j++) {
//                System.out.println(nameList.get(i).substring(j-2,j));
//                System.out.println("temp = " + temp);
                tempList.add(nameList.get(i).substring(j - 2, j));
            }
            nameTemp.add(tempList);
        }
        return nameTemp;
    }

    // 중복된 값이 존재하는 인덱스를 HashSet 으로 중복을 제거하며 반환.
    static HashSet<Integer> findIndex(List<List<String>> nameTemp) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nameTemp.size(); i++) {
            for (int j = 0; j < nameTemp.get(i).size(); j++) {
                if (nameTemp.get(j).contains(nameTemp.get(i).get(j))) {
                    set.add(i);
                }
            }
        }
        return set;
    }
}
