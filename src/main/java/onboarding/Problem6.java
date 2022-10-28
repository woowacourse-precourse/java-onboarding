package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    // 처음 아이디어
    // 각 닉네임마다 두글자씩 잘라서 배열에 받는 함수 생성
    // 두 배열씩 비교하여 겹치는 값이 있는지 확인하는 함수 생성
    // 겹치는 배열이 존재하는 아이디만 정렬 후 반환

    public static String address = "@email.com";
    public static List<String> nameDivideTwo(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() % 2 == 0) {
            for(int i = 0; i < s.length()/2; i++) {
                list.add(String.valueOf(s.charAt(i)+s.charAt(i+1)));
            }
        } else {
            for(int i = 0; i < s.length()/2 + 1; i++) {
                if(i == s.length()/2 + 1) {
                    list.add(String.valueOf(s.charAt(i)));
                }
                list.add(String.valueOf(s.charAt(i)+s.charAt(i+1)));
            }
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
        for (int i = 0; i < nameSplit.size()-1; i++) {
            if(hasCommon(nameSplit.get(i), nameSplit.get(i+1))) {
                // nameSplit.get(i) -> 큐티빠찌뽀찌 = 큐티, 빠찌, 뽀찌
                if(!emailList.contains(forms.get(i).get(0))) {
                // 이메일 이름 리스트에 이미 주어진 이메일이 존재한다면
                    emailList.add(forms.get(i).get(0));
                }
                emailList.add(forms.get(i+1).get(0));
            }
        }
        return emailList;
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
