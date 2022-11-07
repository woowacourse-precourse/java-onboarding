package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> nameDic = new HashMap<>();

        // List -> Map으로 만듦, key에는 닉네임. value에는 이메일
        for(List<String> form: forms){
            nameDic.put(form.get(1), form.get(0));
        }


        // 3중 for문 사용 -> 어떻게 개선시킬 수 있을까
        List<String> values = new ArrayList<>(nameDic.keySet());
        Set<String> tmpAnswer = new HashSet<>();
        for(int i=0; i<values.size(); i++){                             // 닉네임 for문
            String value = values.get(i);
            for(int charIdx=0; charIdx<value.length()-2; charIdx++){    // 닉네임에서 또 인덱스 0부터 돌아가도록, 최소 2글자만 확인하면 됨
                String sub = value.substring(charIdx, charIdx+2);

                for(int j=i+1; j<values.size(); j++){
                    if(tmpAnswer.contains(values.get(j)))           // 이미 결과에 존재하는 닉네임일 경우에는 확인 안하도록
                        continue;

                    if(values.get(j).contains(sub)) {               // 같은 글자가 포함되면 set으로 된 값에 넣도록
                        tmpAnswer.add(values.get(i));
                        tmpAnswer.add(values.get(j));
                    }
                }
            }
        }

        Iterator<String> iter = tmpAnswer.iterator();   // map에서 이메일 불러옴.
        while(iter.hasNext()){
            String nickname = iter.next();
            String email = nameDic.get(nickname);

            answer.add(email);
        }

        Collections.sort(answer);

        return answer;
    }
}
