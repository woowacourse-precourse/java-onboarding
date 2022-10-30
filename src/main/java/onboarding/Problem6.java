package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> nick = new ArrayList<>();   //nickname 저장한 리스트
        List<String> mail = new ArrayList<>();   //mail 저장한 리스트
        List<Integer> result = new ArrayList<>(); //중복된 닉네임 존재하는 인덱스 리스트
        List<String> answer2 = new ArrayList<>(); //result의 인덱스로 메일 추출
        Set<Integer> set; //중복 제거 해줄 set


        for(int i =0; i<forms.size(); i++){ //닉네임과 이메일로 나누기
            nick.add(forms.get(i).get(1));
            mail.add(forms.get(i).get(0));
        }

        for(int i =0; i<nick.size(); i++){
            String str = nick.get(i);
            List<String> subnick = new ArrayList<>(); //substring으로 문자열 두개씩 나눈 리스트, 두개 이상 중복 이어도 앞에 두글자가 같으면 중복으로 처리
            for(int k=0; k<str.length()-1; k++){
                subnick.add(str.substring(k,k+2));
            }
            for(int k=i+1; k<nick.size(); k++){     //substring이 포함된 nick의 인덱스 추출
                for(int j=0; j<subnick.size(); j++){
                    if(nick.get(k).contains(subnick.get(j))){
                        result.add(k);
                        result.add(i); //본인도 넣어야하므로 뒤에서 중복 다 제거할 예정
                    }
                }
            }
        }
        set = new HashSet<Integer>(result); //중복제거
        result = new ArrayList<>(set);

        for (int num : result) { //answer2로 이메일 추출
            answer2.add(mail.get(num));
        }

        Collections.sort(answer2);  //이메일 정렬
        answer = answer2;
        return answer;
    }
}
