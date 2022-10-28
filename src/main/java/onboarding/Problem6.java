package onboarding;

import java.util.*;

public class Problem6 {
    // 처음 아이디어
    // 각 닉네임마다 두글자씩 잘라서 배열에 저장하는 함수 생성
    // 두 배열씩 비교하여 겹치는 값이 있는지 확인하는 함수 생성
    // 겹치는 배열이 존재하는 아이디만 정렬 후 반환

    public static List<String> nameDivideTwo(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++) {
            list.add(String.valueOf(s.charAt(i)+s.charAt(i+1)));
        }
        return list;
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
    public static List<String> finalNameList(List<List<String>> nameSplit, List<List<String>> forms) {
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
        List<List<String>> nameSplit = new ArrayList<>();
        for (List<String> form : forms) {
            nameSplit.add(nameDivideTwo(form.get(1))); //이름을 받아와 쪼갬
        }
        List<String> emailList = finalNameList(nameSplit, forms);
        Collections.sort(emailList);
        return emailList;
    }
}
