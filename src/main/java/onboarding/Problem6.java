package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        //어떤 연속부분문자열을 포함하는 유저의 forms에서의 index들을 set으로 저장
        Map<String,Set<Integer>> subStr_map = new HashMap<String, Set<Integer>>();
        //모든 유저에 대해서
        for(int i=0;i<forms.size();i++){
            String nickname = forms.get(i).get(1);
            //닉네임에서 2~길이만큼 연속되는 문자열을 전부 추출
            for(int select_cnt=2;select_cnt<=nickname.length();select_cnt++){
                //select_cnt만큼 연속되는 모든 문자열 추출
                for(int s=0;s+select_cnt<=nickname.length();s++){
                    //추출된 부분문자열
                    String subStr = nickname.substring(s,s+select_cnt);
                    //맵에 등록되지 않았으면 Set 새로 만들어줌
                    if(!subStr_map.containsKey(subStr)){
                        subStr_map.put(subStr,new HashSet<>());
                    }
                    //맵에 자신의 forms에서의 index 추가
                    subStr_map.get(subStr).add(i);
                }
            }
        }
        //어떤 연속부분문자열을 가진 유저가 2명 이상이라면 resultUserIdx에 추가.
        Set<Integer> resultUserIdx = new HashSet<>();
        Set<Integer> subStr_usrSet;
        for(String s : subStr_map.keySet()){
            subStr_usrSet = subStr_map.get(s);
            if(subStr_usrSet.size() > 1){
                resultUserIdx.addAll(subStr_usrSet);
            }
        }
        //resultUserIdx의 모든 유저들의 이메일을 answer에 추가
        for(int idx : resultUserIdx){
            answer.add(forms.get(idx).get(0));
        }
        //answer 오름차순 정렬
        Collections.sort(answer);

        return answer;
    }

}
