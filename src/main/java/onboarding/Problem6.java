package onboarding;

import java.util.*;

public class Problem6 {
    // 처음 아이디어
    // 닉네임을 두글자씩 겹치게 자른 문자열이 모두 저장된 리스트를 반환하는 함수 생성 - (1)
    // 모든 크루들의 (1)배열을 저장한 List<List<String>> 리스트 반환하는 함수 생성
    // 두 배열끼리 비교하여 겹치는 값의 존재 여부를 반환하는 함수 생성
    // 이중 for문을 활용해 존재하는 모든 크루들의 닉네임이 겹치는지 여부를 확인하고, 그 크루들의 이메일만 담은 배열을 반환하는 함수 생성
    // -> 위의 존재여부 함수를 활용해 반환값이 true면 두 크루의 이메일을 결과 배열에 넣어준다
    // -> ex.form.get(i).get(0) 이 들어가는 이유는 i번째 인덱스(한 크루의 [이메일,닉네임]을 담은 배열)의 0번째 인덱스 값인 이메일을 담기 위해
    // 겹치는 배열이 존재하는 아이디만 정렬(리스트이므로 Collections.sort()활용) 후 반환

    public static List<String> nameDivideTwo(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++) {
            list.add(String.valueOf(s.charAt(i)+s.charAt(i+1)));
        }
        return list;
    }

    public static List<List<String>> splitCrewName(List<List<String>> forms) {
        List<List<String>> splitCrewName = new ArrayList<>();
        for (List<String> form : forms) {
            splitCrewName.add(nameDivideTwo(form.get(1))); //이름을 받아와 쪼갬
        }
        return splitCrewName;
    }

    public static boolean hasCommon(List<String> one, List<String> two) {
        boolean hasCommon = false;
        for (String s_one : one) {
            for (String s_two : two) {
                if (s_one.contains(s_two)) {
                    hasCommon = true;
                    break;
                }
            }
        }
        return hasCommon;
    }

    public static List<String> commonNameList(List<List<String>> nameSplit, List<List<String>> forms) {
        // 쪼개진 이름 리스트들과 문제에서 주어진 조건 리스트를 인자로 받는
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < nameSplit.size()-2; i++) {
            for(int j = i+1; j < nameSplit.size()-1; j++) {
                if(hasCommon(nameSplit.get(i), nameSplit.get(j))) {
                    emailList.add(forms.get(i).get(0));
                    emailList.add(forms.get(j).get(0));
                }
            }
        }
        Set<String> emailSet = new HashSet<>(emailList);
        return new ArrayList<>(emailSet);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> nameSplit = splitCrewName(forms);
        List<String> commonEmailList = commonNameList(nameSplit, forms);
        Collections.sort(commonEmailList);
        return commonEmailList;
    }
}
