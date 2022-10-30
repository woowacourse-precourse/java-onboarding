package onboarding;

import java.util.*;

/**
 * 기능 사항
 * 1.닉네임을 두글자씩 배열에 저장하는 함수
 * 2.배열에서 중복된 문자만 저장해 리턴하는 함수
 * 3.중복문자를 가지고 있는 크루를 배열에 저장하는 함수
 */
public class Problem6 {
    /**
     * 1.닉네임을 두글자씩 배열에 저장하는 함수
     */
    public static List<String> split(List<List<String>> forms){
        List<String> nameList = new ArrayList<>();
        for (int i=0; i<forms.size();i++){
            String NickName = forms.get(i).get(1);
            for(int j=1; j<NickName.length(); j++){
                String overlap = String.valueOf(NickName.charAt(j - 1)) + (NickName.charAt(j));
                nameList.add(overlap);
            }
        }

        return nameList;
    }

    /**
     * 2.배열에서 중복된 문자만 저장해 리턴하는 함수
     */
    public static List<String> overlapCheck(List<String> n){
        Set<String> overlapCheck = new HashSet<>();
        List<String> overlapList = new ArrayList<>();
        for (String Nick : n){
            if(n.indexOf(Nick) != n.lastIndexOf(Nick)){
                overlapCheck.add(Nick);
            }
        }

        Iterator<String> hashList = overlapCheck.iterator();
        while (hashList.hasNext()){
            overlapList.add(hashList.next());
        }

        return overlapList;
    }

    /**
     * 3.중복문자를 가지고 있는 크루를 배열에 저장하는 함수
     */
    public static List<String> verification(List<String> list,List<List<String>> forms){
        List<String> answer = new ArrayList<>();
        for(int x=0; x<list.size(); x++){
            for (int i=0; i<forms.size();i++){
                String NickName = forms.get(i).get(1);
                for(int j=1; j<NickName.length(); j++){

                    if(list.get(x).equals(String.valueOf(NickName.charAt(j - 1)) + (NickName.charAt(j)))){
                        answer.add(forms.get(i).get(0));
                        break;
                    }
                }

            }
        }

        return answer;
    }

    /**
     * 문제 해결을 위한 함수
     * 결과 리턴 전 이메일 중복 제거
     * 오름차순 정렬
     * 기능 요구 사항 결과 리턴
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        nameList = split(forms);

        List<String> overlapList = overlapCheck(nameList);

        answer = verification(overlapList,forms);


        Set<String> emailOverlap = new HashSet<>(answer);
        answer = new ArrayList<>(emailOverlap);

        Collections.sort(answer);
        return answer;
    }
}
