package onboarding;

import java.util.List;
import java.util.ArrayList; //ArrayList를 사용하기 위해 import

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {        
        int pRight = pobi.get(1);
        int pLeft = pobi.get(0);
        int cRight = crong.get(1);
        int cLeft = crong.get(0);
        if(pRight<3 || pRight>398 || pLeft<3 || pLeft>398 || cRight<3 || cRight>398 || cLeft<3 || cLeft>398){
            return -1;
        }
        else if(pRight != pLeft + 1 || cRight != cLeft + 1){
            return -1;
        }                                                                      
        
        List<Integer> listpobiRight = new ArrayList<>();
        while(pRight > 0){
            listpobiRight.add(pRight%10);
            pRight /= 10;                               
        }
        List<Integer> listpobiLeft = new ArrayList<>();
        while(pLeft > 0){
            listpobiLeft.add(pLeft%10);
            pLeft /= 10;
        }
        
        List<Integer> listcrongRight = new ArrayList<>();
        while(cRight > 0){
            listcrongRight.add(cRight%10);
            cRight /= 10;
        }
        
        List<Integer> listcrongLeft = new ArrayList<>();
        while(cLeft > 0){
            listcrongLeft.add(cLeft%10);
            cLeft /= 10;                               // 포비와 크롱이 펼친 페이지들의 각 자리수를 List자료형으로 저장 
        }    
        
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
        
        if(crongMax < pobiMax){
            return 1;
        }
        else if(crongMax > pobiMax){
            return 2;
        }
        else {
            return 0;
        }
        
    }
        
    
}
