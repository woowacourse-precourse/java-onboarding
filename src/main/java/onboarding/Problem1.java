package onboarding;

import java.util.List;
import java.util.ArrayList; //ArrayList를 사용하기 위해 import

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiRight =(int) (Math.random()*197+2)*2;
        int pobiLeft = pobiRight -1;                       
        
        int crongRight =(int) (Math.random()*197+2)*2;
        int crongLeft = crongRight -1;                     //포비와 크롱의 임의의 페이지 두쪽
        
        List<Integer> listpobiRight = new ArrayList<>();
        while(pobiRight > 0){
            listpobiRight.add(pobiRight%10);
            pobiRight /= 10;                               
        }
        List<Integer> listpobiLeft = new ArrayList<>();
        while(pobiLeft > 0){
            listpobiLeft.add(pobiLeft%10);
            pobiLeft /= 10;
        }
        
        List<Integer> listcrongRight = new ArrayList<>();
        while(crongRight > 0){
            listcrongRight.add(crongRight%10);
            crongRight /= 10;
        }
        
        List<Integer> listcrongLeft = new ArrayList<>();
        while(crongLeft > 0){
            listcrongLeft.add(crongLeft%10);
            crongLeft /= 10;                               // 포비와 크롱이 펼친 페이지들의 각 자리수를 List자료형으로 저장 
            
        int pobiRightsum = 0;
        for (int i=0; i < listpobiRight.size(); i++){
            pobiRightsum += listpobiRight.get(i);
        }
        
        int pobiRightmultipl = 1;
        for (int i =0; i < listpobiRight.size(); i++){
            pobiRightmultipl *= listpobiRight.get(i);
        }
        int pobiLeftsum = 0;
        for (int i=0; i < listpobiLeft.size(); i++){
            pobiLeftsum += listpobiLeft.get(i);
        }
        
        int pobiLeftmultipl = 1;
        for (int i =0; i < listpobiLeft.size(); i++){
            pobiLeftmultipl *= listpobiLeft.get(i);
        }
        int pobiMax = 0;
        
        int[] pobiValue ={pobiRightsum, pobiRightmultipl, pobiLeftsum, pobiLeftmultipl};
        
        for(int i : pobiValue) pobiMax = Math.max(i,pobiMax);

        int crongRightsum = 0;
        for (int i=0; i < listcrongRight.size(); i++){
            crongRightsum += listcrongRight.get(i);
        }
        
        int crongRightmultipl = 1;
        for (int i =0; i < listcrongRight.size(); i++){
            crongRightmultipl *= listcrongRight.get(i);
        }
        int crongLeftsum = 0;
        for (int i=0; i < listcrongLeft.size(); i++){
            crongLeftsum += listcrongLeft.get(i);
        }
            
        int crongLeftmultipl = 1;
        for (int i =0; i < listcrongLeft.size(); i++){
            crongLeftmultipl *= listcrongLeft.get(i);
        }
        int crongMax = 0;
        
        int[] crongValue ={crongRightsum, crongRightmultipl, crongLeftsum, crongLeftmultipl};
        
        for(int i : crongValue) crongMax = Math.max(i,crongMax);        // 포비와 크롱의 왼쪽 오른쪽 각각의 합과 곱을 구하고 그중의 최대값을 뽑아냈다.

        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
