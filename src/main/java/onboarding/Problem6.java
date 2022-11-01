package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        List<String> answer = new ArrayList<>();
        HashMap<String,String> checkMap = new HashMap<>();
        Set<String> answerSet = new HashSet<>();

        // form을 하나씩 돌면서 중복되는 단어가 있는지 체크
        forms.stream().forEach(form -> {

            // 만약 처음에 map이 비어있다면 -> 바로 map에 값 넣기
            if(checkMap.isEmpty())
            {
                checkMap.put(form.get(1),form.get(0));
            }
            else
            {

                for(int i =0; i < form.get(1).length() -1;i++)
                {
                    // 연속된 두 글자씩 끊어서 가져오기
                    String temp = form.get(1).substring(i,i+2);

                    // map 내부에 존재하는 요소들
                    checkMap.entrySet().forEach(map -> {

                        // 비교하려는 크루 닉네임이 연속된 같은 글자를 가지고 있는지 체크
                        boolean contains = map.getKey().contains(temp);

                        // 만약 포함한다면 set에 추가, 중복은 허용안하므로 set 사용
                        if (contains)
                        {
                            answerSet.add(form.get(0));
                            answerSet.add(map.getValue());
                        }
                    });

                }

                // 전체 form을 대상으로 비교할 수 있도록 중복 닉네임 발견 여부 상관 없이 map에 추가
                checkMap.put(form.get(1),form.get(0));
            }
        });

        answerSet.forEach(set -> {
            answer.add(set);
        });

        return answer;
    }
    }

