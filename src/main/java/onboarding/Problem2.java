package onboarding;

import java.util.ArrayList;
import java.util.List;
//전체적으로 리펙토링이 필요해 보인다.
public class Problem2 {
    public static int check_same(String string_a, int index){
        if(index+1>=string_a.length()) return index;
        if(string_a.charAt(index) == string_a.charAt(index+1)){
            index = check_same(string_a,index+1);
        }
        return index;
    }
    public static String solution(String cryptogram) {
        //제한 조건
        String answer = cryptogram;
        int cnt=0;
        // 더이상 중복 문자가 없을 경우 break
        while(true){
            // 삭제를 위한 변수들 초기화, 할당 점점 줄어들어도 되므로 초기화
            cnt=0;
            int[][] delete_indexes = new int[answer.length()][];
            // 비교 시작
            for(int i=0;i<answer.length();i++){
                // 마지막 문자일 경우 비교 x
                if (i==(answer.length()-1)) continue;
                // 중복된 친구들의 인덱스값을 따로 저장해서 나중에 처리하자.
                int temp = check_same(answer,i);
                if (temp != i){
                    delete_indexes[cnt] = new int[]{i, temp};
                    cnt++;
                    i=temp;
                }
            }
            // cnt == 중복된 문자들의 종류 갯수,0이면 없으므로 종료
            if(cnt==0) break;
            for(int j=0;j<cnt;j++){
                answer = answer.substring(0,delete_indexes[j][0]-(j*2))+
                answer.substring(delete_indexes[j][1]-(j*2)+1);
            }
        }

        return answer;
    }
}
