package onboarding;
//1. 선택한 닉네임 안의 첫 글자 부터 시작해서 두 글자 씩 끊어서 필터 생성
//2. 필터를 이용해서 1에서 선택된 다음 닉네임 부터 필터를 이용하여 중복된 부분 검사
//3. 중복되는 부분이 있는 이메일 answer 에 추가
//4. 리스트 내부에 있는 모든 닉네임을 선택될 때 까지 1 ~ 5를 반복
//5. answer 를 정렬 후 반환
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> copied_form = new ArrayList<>(forms);
        HashSet<String> answer_set = new HashSet<>();
        String filter;
        int flag = 0;
        int index = 0;
        while(true)
        {
            //탈출 조건
            if(index == copied_form.size() - 1)
                break;
            for(int i = 0; i < copied_form.get(index).get(1).length() - 1; i++)
            {
                //1. 선택한 닉네임 안의 첫 글자 부터 시작해서 두 글자 씩 끊어서 필터 생성
                filter = "" + copied_form.get(index).get(1).charAt(i) + copied_form.get(index).get(1).charAt(i + 1);
                //2. 필터를 이용해서 1에서 선택된 다음 닉네임 부터 필터를 이용하여 중복된 부분 검사
                for(int j = index + 1; j < copied_form.size(); j++)
                {
                    if(copied_form.get(j).get(1).contains(filter))
                    {
                        flag = 1;
                        answer_set.add(copied_form.get(j).get(0));
                    }
                }
            }

        }
        List<String> answer = new ArrayList<>(answer_set);
        Collections.sort(answer);
        return answer;
    }
}
