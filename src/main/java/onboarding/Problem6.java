package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();
        List<String> split = new ArrayList<>();
        Set<String> freq = new HashSet<>();


        //2문자로 쪼개기
        for (int i =0; i < forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j = 0; j < nickname.length()-1; j++){
                split.add(nickname.substring(j,j+2));
            }
        }
        // 중복 값 추출
        freq = split.stream().filter(i -> Collections.frequency(split, i) > 1).collect(Collectors.toSet());
        System.out.println(freq);
        List<String> target = new ArrayList<>(freq);

        // 중복값을 포함한 이메일 추출
        Iterator iter = freq.iterator();
        for (int i =0; i < forms.size(); i++){
            for (String t : target){
                String nickname = forms.get(i).get(1);
                if(nickname.contains(t)){
                    answer.add(forms.get(i).get(0));
                }
            }
        }

        // answer(이메일) 정렬
        Collections.sort(answer);
            return answer;
    }
}

/**
 * 기능 요구사항
 * 1. 닉네임이 두글자 이상이 연속적으로 중복인지 체크
 * 2. 이메일 문자열 오름차순 정렬
 * 예외 처리
 * 1. 이메일은 이메일 형식, 전체 길이 11이상 20 미만
 * 2. 닉네임이 한글인지
 * 3. 같은 이메일이 없는지
 * **/