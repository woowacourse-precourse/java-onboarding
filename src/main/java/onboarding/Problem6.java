package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Hashtable<String,String> hashtable = new Hashtable<>(); // 이름과 이메일을 저장할 해쉬 테이블
        TreeSet<String> treeSet = new TreeSet<>(); // 이메일을 오름차순 정렬하고 중복은 제거할 트리셋
        for (List<String> form: forms // 모든 입력을 확인
             ) {
            for (int i = 1; form.get(1).length() > i; i++){ //이름을 자르기 위한 반복문
                if (hashtable.get(form.get(1).substring(i-1,i+1)) == null){ // 연속된 두글자가 해쉬 테이블에 없다면
                    hashtable.put(form.get(1).substring(i-1,i+1), form.get(0)); // 해쉬테이블을 업데이트
                }
                else { // 해쉬 테이블에 이미 존재한다면
                    treeSet.add(form.get(0)); // 메일과
                    treeSet.add(hashtable.get(form.get(1).substring(i-1,i+1))); // 해쉬테이블에 있는 메일을 업데이트
                }
            }
        }
        return new ArrayList<>(treeSet);
    }
}