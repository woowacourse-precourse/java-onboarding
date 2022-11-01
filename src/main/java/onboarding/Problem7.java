package onboarding;

import java.util.*;
import java.util.stream.Collectors;
//1.친구관계 정리
//해시셋으로 친구 목록에 키값으로 조재하는지 검색
//없으면
//해시셋에 이름 추가
//리스트에도 추가
//있으면
//리스트 위치 찾아서 추가
//2.친구관계 점수 계산
// 각 리스트 탐색하면서 user의 목록비교고 친구 포함하면 +10
//3.방문자 점수
//방문자 이름에 해당하는 점수 +1
//4.result정렬 (점수, 이름 순)
//5.최대 5명 저장
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> res = new ArrayList<>();

        List<List<String>> fr2 = new ArrayList<>();
        for(int i=0;i<10000;i++){
            fr2.add(new ArrayList<>());
        }
        List<String> nameList = new ArrayList<>();
        int[] sc = new int[10010];

        //1.친구관계 정리
        //해시셋으로 친구 목록에 키값으로 조재하는지 검색
        //없으면
        //해시셋에 이름 추가
        //
        //리스트에도 추가
        //있으면
        //리스트 위치 찾아서 추가
        for(int i=0;i< friends.size();i++){
            String na1 = friends.get(i).get(0);
            String na2 = friends.get(i).get(1);

            // 1번 이름
            if(!nameList.contains(na1)){
                nameList.add(na1);
                fr2.get(nameList.indexOf(na1)).add(na2);
            }
            else {
                fr2.get(nameList.indexOf(na1)).add(na2);
            }
            //2번 이름
            if(!nameList.contains(na2)){
                nameList.add(na2);
                fr2.get(nameList.indexOf(na2)).add(na1);
            }
            else {
                fr2.get(nameList.indexOf(na2)).add(na1);
            }
        }
        //2.친구관계 점수 계산
        // 각 리스트 탐색하면서 user의 목록비교고 친구 포함하면 +10
        for(int i=1;i<nameList.size();i++){
            if(nameList.get(i).equals(user)){continue;}

            String cur = nameList.get(i);
            if(!fr2.get(nameList.indexOf(user)).contains(cur)){// 친구가 아닌 경우에만
                if(fr2.get(i).size()!=0){
                    for(int j=0;j<fr2.get(i).size();j++){
                        String curNa = fr2.get(i).get(j);
                        if(fr2.get(nameList.indexOf(user)).contains(curNa)){
                            sc[i]+=10;
                        }
                    }
                }
            }

        }
        //3.방문자 점수
        //이미 친구인 경우 제외 방문자 이름에 해당하는 점수 +1
        for(int i=0;i< visitors.size();i++){
            String curNa = visitors.get(i);
            if(!nameList.contains(curNa)){
                nameList.add(curNa);
            }
            if(!fr2.get(nameList.indexOf(user)).contains(curNa)){
                sc[nameList.indexOf(curNa)]+=1;
            }
        }
        //4.result정렬 (점수, 이름 순)
        // 이름, 점수를 해시맵에 넣은다름
        // 정렬
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0;i<sc.length;i++){
            if(sc[i]!=0) {
                hash.put(nameList.get(i), sc[i]);
            }
        }
        List<Map.Entry<String, Integer>> hashes = hash.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        //5.최대 5명 저장
        for(int i=0;i<hashes.size();i++){
            res.add(hashes.get(i).getKey());
            if(i==4){break;}
        }
        return answer=res;
    }
}