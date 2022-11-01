package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getEmailList(forms);

        return answer;
    }

    // 중복 체크 메소드
    public static List<String> getEmailList(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> nameList = wordList(forms.get(i).get(1));
            for (int j = 0; j < forms.size(); j++) {
                if (i != j) {
                    List<String> nameList2 = wordList(forms.get(j).get(1));
                    for (int k = 0; k < nameList.size(); k++) {
                        for (int l = 0; l < nameList2.size(); l++) {
                            if (nameList.get(k).equals(nameList2.get(l))) {
                                list.add(forms.get(i).get(0));
                            }
                        }
                    }
                }
            }
        }
        Set<String> set = new HashSet<>(list);
        List<String> resultList = new ArrayList<>(set);
        return arraySort(resultList);
    }

    // 전달인자로 받은 이름을 두 글자씩 나누는 메소드
    public static List<String> wordList(String name) {
        List<String> sliceName = new ArrayList<>();
        for (int i = 0; i < name.length() - 1; i++) {
            if (i != name.length() - 1) {
                sliceName.add(name.substring(i, i + 2));
            }
        }
        return sliceName;
    }

    // 문자열 비교 메소드
    public static List<String> arraySort(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String text1 = o1.split("@")[0];
                String text2 = o2.split("@")[0];
                return text1.compareTo(text2);
            }
        });
        return list;
    }
}