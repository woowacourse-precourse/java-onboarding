package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder s =new StringBuilder(cryptogram);

        int cnt = 1;

        // cnt 변수를 활용해, 더 반복할지 말지 결정
        while(cnt >= 1){
            cnt = 0;
            ArrayList<Integer> del_arr = new ArrayList<Integer>();

            // 1칸 차이나는 두 인덱스가 서로 같으면 delete를 위한 마스킹 처리
            for(int i=1; i<s.length();i++){
                if (s.charAt(i) == s.charAt(i-1)){
                    del_arr.add(i-1);
                    del_arr.add(i);
                    cnt += 1;
                }
            }

            // 마스킹된 인덱스를 활용해 string에서 char 제거
            for(int i=0; i<del_arr.size();i++){
                int idx = del_arr.get(i);
                s.deleteCharAt(idx);
                for(int j=i+1; j<del_arr.size();j++){
                    // idx 범위 에러 안나도록, 최소 한개 이상의 element 보장
                    if(i+1 < del_arr.size()) del_arr.set(j, del_arr.get(j) - 1); // 값 변경
                }
            }
        }

        String answer = s.toString();
        return answer;
    }
}
