package onboarding;

import java.util.List;
import java.util.ArrayList;

// {이메일, 닉네임} 리스트 형식으로 구성된 리스트가 forms 파라미터로 주어짐
// >> { {'asd', 'fgh'}, {'zxc', 'qwe'}, {'cvb', 'qwe'}, ... }
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // return 값인 answer 초기화
        List<String> answer = List.of("answer");

        // nickname 빈 어레이 리스트 생성
        ArrayList<String> nickname = new ArrayList<String>();

        // out리스트의 index번호를 가져옴 >> in리스트의 index( string > char[] )로 만들기
        for (int i = 0; i < forms.size(); i++) {
            List<String> lst = forms.get(i);



        }

        // answer 오름차순 정렬하기


        return answer;
    }
    }
