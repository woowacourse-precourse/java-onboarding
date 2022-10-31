package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        System.out.println(solution(
                Arrays.asList(Arrays.asList("jm@email.com", "제이엠"),Arrays.asList("jason@email.com", "제이슨"),
                        Arrays.asList("woniee@email.com", "워니"),Arrays.asList("mj@email.com", "엠제이"),Arrays.asList("nowm@email.com", "이제엠"))
        ));
    }
    public static List<String> solution(List<List<String>> forms) {
        Hashtable<String,String> hashtable = new Hashtable<>(); // 이름과 이메일을 저장할 해쉬 테이블
        HashSet<String> hashSet;// 닉넴임을 두 글자씩 자를 경우 중복이 되면 안 되기 때문에
        TreeSet<String> treeSet = new TreeSet<>(); // 이메일을 오름차순 정렬하고 중복은 제거할 트리셋
        for (List<String> form: forms // 모든 입력을 확인
             ) {
            if (form.get(1).length() < 2) continue;
            hashSet = new HashSet<>();
                for (int i = 1; i < form.get(1).length(); i++){ //이름을 자르기 위한 반복문
                   hashSet.add(form.get(1).substring(i-1,i+1));
                }
            hashSet.forEach(nameSub -> {
                if (hashtable.containsKey(nameSub)) {
                    // 해쉬 테이블에 이미 존재한다면
                    treeSet.add(form.get(0)); // 메일과
                    treeSet.add(hashtable.get(nameSub)); // 해쉬테이블에 있는 메일을 트리셋에 추가
                }
                else { //없다면
                    hashtable.put(nameSub, form.get(0)); // 자른 닉네임과 이메일을 해시 테이블에 추가.
                }
            });
        }
        return new ArrayList<>(treeSet);
    }
}