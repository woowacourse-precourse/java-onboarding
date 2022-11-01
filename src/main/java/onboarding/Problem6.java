package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>(); // 중복 및 오름차순 정렬 위해 TreeSet으로 선언
        Map<String, String> users = new HashMap<>(); // 크루들의 닉네임을 두글자씩 분리해서 이메일 주소와 함께 저장한 목록
        HashSet<String> mail_addrs = new HashSet<>(); // 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 주소 목록


        for(int i = 0; i < forms.size(); i++) {
            String mail_addr = forms.get(i).get(0);
            String name = forms.get(i).get(1);

            // 크루들의 닉네임 중 같은 글자가 연속적으로 포함되는 경우 체크
            for (int j = 0; j < name.length()-1; j++) {
                String chk_name = name.substring(j, j+2);
                // 크루들의 닉네임을 두글자씩 분리해서 이메일 주소와 함께 저장
                if(!users.containsKey(chk_name)) {
                    users.put(chk_name, mail_addr);
                }  // 두글자씩 분리한 닉네임이 이미 있다면 중복이므로 이메일 주소 저장
                else {
                    mail_addrs.add(users.get(chk_name));
                    mail_addrs.add(mail_addr);
                }
            }
        }
        // 중복 제거 및 오름차순 정렬을 위해 TreeSet로 선언한 answer에 값 넣기
        Iterator iter = mail_addrs.iterator();
        while(iter.hasNext()) {
            answer.add((String) iter.next());
        }

        // 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 ArrayList로 return
        return new ArrayList<>(answer);
    }
}
