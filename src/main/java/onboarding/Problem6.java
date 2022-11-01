package onboarding;

import java.util.*;


class Crew{
    private String email;
    private String nickname;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}

/*
기능 목록
1. 중복 닉네임 검출
2. 중복 닉네임 오름차순 중복제거 출력
3. 이메일 입력 형식 예외 처리
4. 닉네임 입력 형식 예외 처리
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> result = new HashSet<>();

        List<Crew> crews = new ArrayList<>();
        for (List<String> l : forms) {
            crews.add(new Crew(l.get(0), l.get(1)));
        }

        Map<String, String> nicknameSplit = new HashMap<>();
        for(Crew c : crews){
            String email = c.getEmail();
            String nickname = c.getNickname();
            List<String> splitList = new ArrayList<>();

            for(int i = 0; i < nickname.length() - 1; i++){
                String sub = nickname.substring(i, i + 2);
                splitList.add(sub);
            }

            for(String nickSub : splitList){
                if(!nicknameSplit.containsKey(nickSub)){
                    nicknameSplit.put(nickSub, email);
                    continue;
                }

                String ogEmail= nicknameSplit.get(nickSub);
                result.add(ogEmail);
                result.add(email);

                nicknameSplit.put(nickSub, email);
            }
        }


        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }
}
