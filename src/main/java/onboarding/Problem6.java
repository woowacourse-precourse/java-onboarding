package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        //HashMap: key=닉네임 중 2글자만 추출한값, value=이메일
        HashMap<String, String> hashMap = new HashMap<>();
        //TreeSet: 정답을 저장하기 위한 자료구조. 중복제거와 정렬 동시에 가능
        TreeSet<String> treeSet = new TreeSet<>();

        for(List<String> list : forms){
            HashSet<String> hashSet = new HashSet<>();
            String nickname = list.get(1); //신청한 닉네임
            //신청한 닉네임을 두글자씩 잘라서 HashSet에 저장(중복 제거)
            for(int i=0; i<nickname.length()-1; i++)
                hashSet.add(nickname.substring(i, i+2));

            for(String s : hashSet){
                //잘라낸 닉네임의 2글자가 hashMap에 없으면 추가
                if(!hashMap.containsKey(s))
                    hashMap.put(s, list.get(0));
                //이미 hashMap에 존재한다면 이어진 두글자가 곂치는 다른 닉네임이 존재한다는 것.
                //이 닉네임을 신청한 사람의 이메일과 hashmap에 등록한 사람의 이메일을 treeset에 저장.
                else{
                    treeSet.add(list.get(0));
                    treeSet.add(hashMap.get(s));
                }
            }
        }

        List<String> answer = new ArrayList<>(treeSet);

        return answer;
    }
}
