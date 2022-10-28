package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        forms = new ArrayList<>(forms);
        ArrayList<String> separateName = new ArrayList<String>();

        for ( int s=0;forms.size()>s;s++){
            for (int k=0;forms.get(s).size()-1>k;k++){
              separateName.add(String.valueOf(forms.get(s).get(1).charAt(k))+(forms.get(s).get(1).charAt(k+1)));
            }
        }
        System.out.println("나눠짐"+separateName);
// 배열내 이름을 2글자씩 나눠 separateName에 담음 . 블록커 : 두번째 for문에서 size() 에서 size()-1로 수정함.

        ArrayList<String> checkDuplicateName = new ArrayList<String>();

        for  ( int s=0;separateName.size()>s;s++){
            for (int k=0;separateName.size()>k;k++){
                if (s != k && Objects.equals(separateName.get(s), separateName.get(k))){
                    checkDuplicateName.add(separateName.get(s));
                }
            }
        }
        System.out.println("중복체크"+checkDuplicateName);
//seprateName에서 중복값이 존재하는 경우에만 checkDuplicateName에 담음. 블록커 : ==연산이 적용되지않고 Objects.equals로 변경하여 비교해야함
        HashSet<String> hashSet = new HashSet<>(checkDuplicateName);
        System.out.println(hashSet);
//HashSet을 이용한 중복제거


        List<String> answer = List.of("answer");
        return answer;
    }
}
