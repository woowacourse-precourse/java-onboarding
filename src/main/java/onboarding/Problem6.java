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
    // 정렬 시 "@email.com"은 제외하고 정렬 뒤 다시 뒷문장은 붙여줌

    public static String address = "@email.com";
    public static List<String> nameDivideTwo(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.length() % 2 == 1 && i == s.length()-1) {
                list.add(String.valueOf(s.charAt(i)));
            }
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
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < nameSplit.size()-1; i++) {
            if(hasCommon(nameSplit.get(i), nameSplit.get(i+1))) {
                if(!emailList.contains(nameSplit.get(i).get(0))) {
                    emailList.add(forms.get(i).get(0));
                }
                emailList.add(forms.get(i).get(1));
            }
        }
        return emailList;
    }
    public static List<String> sortList(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            s = s.replace(address, "");
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            newList.add(Arrays.toString(arr)+address);
        }
        return newList;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> nameSplit = new ArrayList<>();
        for (List<String> form : forms) {
            nameSplit.add(nameDivideTwo(form.get(1)));
        }
        List<String> emailList = finalNameList(nameSplit, forms);
        return sortList(emailList);
    }
}
