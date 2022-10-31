package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        //key : 닉네임 내 연속된 두글자, value : 닉네임의 인덱스
        //ex {이제=[4], 제이=[0, 1, 3], 이엠=[0], 워니=[2], 엠제=[3], 이슨=[1], 제엠=[4]}
        HashMap<String, List<Integer>> overlap_name_map = new HashMap<>();
        for (int i = 0; i < forms.size(); i++){
            for (int j = 0; j < forms.get(i).get(1).length()-1; j++){
                String two_letters = forms.get(i).get(1).substring(j,j+2);
                if (!overlap_name_map.containsKey(two_letters)) overlap_name_map.put(two_letters, new ArrayList<>(Arrays.asList(i)));
                else overlap_name_map.get(two_letters).add(i);
            }
        }

        //이메일 중복 제거를 위한 HashSet
        HashSet<String> target_email_set = new HashSet<>();
        for (String two_letter : overlap_name_map.keySet()){
            //해당 연속된 두글자가 포함된 닉네임이 1건보다 많을 경우 제한
            if (overlap_name_map.get(two_letter).size() > 1){
                for (Integer idx : overlap_name_map.get(two_letter)){
                    target_email_set.add(forms.get(idx).get(0));
                }
            }
        }

        //답은 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬
        List<String> answer = new ArrayList<>(target_email_set);
        Collections.sort(answer);

        return answer;
    }
}
