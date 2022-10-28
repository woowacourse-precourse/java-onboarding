package onboarding;

import java.util.List;
import java.util.ArrayList; //ArrayList를 사용하기 위해 import

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiright =(int) (Math.random()*197+2)*2;
        int pobileft = pobiright -1;                       
        
        int crongright =(int) (Math.random()*197+2)*2;
        int crongleft = crongright -1;                     
        
        List<Integer> listpobiright = new ArrayList<>();
        while(pobiright > 0){
            listpobiright.add(pobiright%10);
            pobiright /= 10;                               
        }
        List<Integer> listpobileft = new ArrayList<>();
        while(pobileft > 0){
            listpobileft.add(pobileft%10);
            pobileft /= 10;
        }
        
        List<Integer> listcrongright = new ArrayList<>();
        while(crongright > 0){
            listcrongright.add(crongright%10);
            crongright /= 10;
        }
        
        List<Integer> listcrongleft = new ArrayList<>();
        while(crongleft > 0){
            listcrongleft.add(crongleft%10);
            crongleft /= 10;                               // 포비와 크롱이 펼친 페이지들의 각 자리수를 List자료형으로 저장 
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
