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
        }

        List<String> answer = new ArrayList<>(treeSet);

        return answer;
    }
}
