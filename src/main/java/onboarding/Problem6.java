package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    //2문자로 쪼개기
    public static List<String> splitTwoWord (List<List<String>> forms){
        List<String> arr = new ArrayList<>();

        for (int i =0; i < forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j = 0; j < nickname.length()-1; j++){
                arr.add(nickname.substring(j,j+2));
            }
        }
        return arr;
    }
    // 중복 값 추출
    public static List<String> filterFreq(List<String> split){
        Set<String> freq = new HashSet<>();
        // 1번을 초과하여 (2번 이상) 중복해서 나타나는 크기가 2인 단어 추출
        freq = split.stream().filter(i -> Collections.frequency(split, i) > 1).collect(Collectors.toSet());
        
        // set을 List화
        List<String> result = new ArrayList<>(freq);
        return result;
    }

    // 중복값을 포함하고 있는 이메일을 추출하는 메소드
    public static  List<String> filterEmail(List<List<String>> forms, List<String> target){
        List<String> result = new ArrayList<>();

        for (int i =0; i < forms.size(); i++){
            for (String t : target) {
                String nickname = forms.get(i).get(1);
                if(nickname.contains(t)){
                    result.add(forms.get(i).get(0));
                }
            }
        }
        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        // nickname을 2문자로 split 한 후 중복인 값 추출
        List<String> target = new ArrayList<>(filterFreq(splitTwoWord(forms)));
        // 중복값을 포함한 이메일 추출
        answer = filterEmail(forms, target);

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