package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        //nickNames = form에서 닉네임만 추출하고 한글자씩 분리하여 배열로 저장
        List<List<String>> nickNames = new ArrayList<>();
        for (int i=0;i<forms.size();i++){
            nickNames.add(Arrays.asList(forms.get(i).get(1).split("")));
        }

        //splitNames = 이웃하는 두글자씩 묶어 set을 형성
        List<List<String>> splitNames = new ArrayList<>();
        for (int i=0;i<nickNames.size();i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < nickNames.get(i).size()-1; j++) {
                temp.add(nickNames.get(i).get(j) + nickNames.get(i).get(j+1));
            }
            splitNames.add(temp);
        }

        //idx = 닉네임 중복이 발생하는 리스트의 인덱스를 저장
        HashSet<Integer> idx = new HashSet<>(); // 인덱스 값 중복 제거를 위해 HashSet으로 선언
        for (int i=0;i<splitNames.size()-1;i++){
            for(int j = 0; j < splitNames.get(i).size(); j++){
                String target=splitNames.get(i).get(j);
                for(int k=i+1; k<splitNames.size();k++) {
                    for (int h = 0; h < splitNames.get(k).size(); h++) {
                        if(target.equals(splitNames.get(k).get(h))){
                            idx.add(i);
                            idx.add(k);
                        }
                    }

                }
            }
        }

        //idx에 저장된 index 값을 사용하기 위해 resultIdx로 copy
        List<Integer> resultIdx = new ArrayList<>();
        Iterator iter =idx.iterator();
        while(iter.hasNext()){
            resultIdx.add((Integer) iter.next());
        }
        //answer = 닉네임 중복이 발생한 크루의 이메일 주소를 저장
        for (int i=0;i<resultIdx.size();i++) {
            answer.add(forms.get(resultIdx.get(i)).get(0));
        }
        Collections.sort(answer); // 오름차순 정렬

        return answer;
    }
}
