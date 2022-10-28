package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        forms = new ArrayList<>(forms);
        ArrayList<String> separateName = new ArrayList<String>();

        for (int s=0;forms.size()>s;s++){
            for (int k=0;forms.get(s).size()-1>k;k++){
              separateName.add(String.valueOf(forms.get(s).get(1).charAt(k))+(forms.get(s).get(1).charAt(k+1)));
            }
        }
        System.out.println("나눠짐"+separateName);
// 배열내 이름을 2글자씩 나눠 separateName에 담음 . 블록커 : 두번째 for문에서 size() 에서 size()-1로 수정함.

        ArrayList<String> checkDuplicateName = new ArrayList<String>();

        for  (int s=0;separateName.size()>s;s++){
            for (int k=0;separateName.size()>k;k++){
                if (s != k && Objects.equals(separateName.get(s), separateName.get(k))){
                    checkDuplicateName.add(separateName.get(s));
                }
            }
        }
        System.out.println("중복체크"+checkDuplicateName);
//seprateName에서 중복값이 존재하는 경우에만 checkDuplicateName에 담음. 블록커 : ==연산이 적용되지않고 Objects.equals로 변경하여 비교해야함
        HashSet<String> hashSet = new HashSet<>(checkDuplicateName);
        ArrayList<String> duplicateName = new ArrayList<String>(hashSet);
//HashSet을 이용한 중복제거 후 다시 duplicateName 동적배열로 선언

        ArrayList<String> getEmail = new ArrayList<String>();
        for  (int s=0;forms.size()>s;s++){
            for (int k=0;duplicateName.size()>k;k++){
                if (forms.get(s).get(1).contains(duplicateName.get(k))){
                    getEmail.add(forms.get(s).get(0));
                }
            }
        }
        System.out.println(getEmail);
// duplicateName이 포함되어있는 유저의 이메일을 getEmail에 add
//forms.get(s).get(1).indexOf(duplicateName.get(k) --> forms.get(s).get(1).contains(duplicateName.get(k)) 리팩토링
        HashSet<String> hashSet2 = new HashSet<>(getEmail);
        ArrayList<String> getDupUserEmail = new ArrayList<String>(hashSet2);
//HashSet을 이용한 중복제거 후 다시 getDupUserEmail 동적배열로 선언
        Collections.sort(getDupUserEmail);
//Coletions.sort()를 통해 오름차순 정렬;


        List<String> answer = getDupUserEmail;
        return answer;
    }
}
