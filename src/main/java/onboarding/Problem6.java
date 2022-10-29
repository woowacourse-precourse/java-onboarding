package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = new ArrayList<>(Arrays.asList(Arrays.asList("jm@email.com", "제이엠"),Arrays.asList("jason@email.com", "제이슨"),
                Arrays.asList("woniee@email.com", "워니"),Arrays.asList("mj@email.com", "엠제이"),Arrays.asList("nowm@email.com", "이제엠")));
        System.out.println(solution(forms));
    }
    public static List<String> solution(List<List<String>> forms) {

        Hashtable<String,String> hashtable = new Hashtable<>(); // 이름과 이메일을 저장할 해쉬 테이블
        HashSet<String> hashSet; // 닉네임이 중복되지 않은 두글자를 저장하기 위해
        TreeSet<String> treeSet = new TreeSet<>(); // 이메일을 오름차순 정렬하고 중복은 제거할 트리셋
        for (List<String> form: forms // 모든 입력을 확인
             ) {
            for (int i = 1; form.get(1).length() > i; i++){
                if (hashtable.get(form.get(1).substring(i-1,i+1)) == null){
                    hashtable.put(form.get(1).substring(i-1,i+1), form.get(0));
                }
                else {
                    treeSet.add(form.get(0));
                    treeSet.add(hashtable.get(form.get(1).substring(i-1,i+1)));
                }
            }
        }
        return new ArrayList<>(treeSet);
    }
}