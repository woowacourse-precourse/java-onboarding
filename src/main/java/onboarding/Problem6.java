package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution1(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Iterator<List<String>> iterator = forms.iterator();
        while (iterator.hasNext()) {

            List<String> next = iterator.next();
            System.out.println("iterator.next() = " + next.get(1));

        }


        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        boolean[] check = new boolean[forms.size()]; // answer 배열에 add한 여부

        for(int i=0;i<forms.size();i++){ // 순회하면서
            String name = forms.get(i).get(1); // i번째 닉네임
            if(check[i]) continue; // 이미 answer 배열에 추가된 경우 pass
            if(name.length()==1) continue; // 닉네임 길이가 1인 경우 pass

            // 모든 닉네임과 비교
            for(int j=0;j<forms.size();j++){
                if(i==j) continue; // 자기자신인 경우 pass
                if(IsDuplicate(name, forms.get(j).get(1))){ // 중복인 경우 check
                    if(check[i]==false){ // 현재 닉네임이 answer 배열에 없는 경우
                        check[i]=true;
                        answer.add(forms.get(i).get(0));
                    }
                    if(check[j]==false){ // 비교 닉네임이 answer 배열에 없는 경우
                        check[j]=true;
                        answer.add(forms.get(j).get(0));
                    }
                }
            }
        }

        Collections.sort(answer); // 정렬
        return answer;
    }

    // name과 other 중복 여부
    private static boolean IsDuplicate(String name, String other){
        if(other.length()==1) return false; // 비교 닉네임 길이가 1인 경우
        int compareNum = Math.min(name.length(), other.length()); // 비교 문자열 최대 길이
        for(int c=2; c<=compareNum; c++){ // 2, 3, ... compareNum개 문자가 일치하는지 확인...
            // name, other 문자열의 c 길이 문자열의 모든 경우의 수 비교
            for(int i=0;i<=name.length()-c;i++){
                for (int j=0; j<=other.length()-c; j++){
                    if (name.substring(i,i+c).equals(other.substring(j,j+c))) // 문자열 일치하는 경우
                        return true;
                }
            }
        }
        return false;
    }
    
}
