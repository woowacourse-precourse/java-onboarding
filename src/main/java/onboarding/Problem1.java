package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();
        
        Integer pobiAnswer = problem1.pageSelect(pobi);
        Integer crongAnswer = problem1.pageSelect(crong);
        
        if(pobiAnswer < 0 || crongAnswer < 0) return -1;
        Integer answer = (pobiAnswer>crongAnswer)? 1:((pobiAnswer<crongAnswer)? 2:((pobiAnswer==crongAnswer)? 0:-1));
        
        return answer;
    }// solution
    
    private Integer pageSelect(List<Integer> whoPage) {    	
    	Integer leftPage = whoPage.get(0);
    	Integer rightPage = whoPage.get(1);

    	Integer leftResult = pageCalculate(leftPage);
    	Integer rightResult = pageCalculate(rightPage);

    	Integer result = (leftResult >= rightResult)?leftResult:rightResult;
    	
    	return (leftPage.equals(rightPage-1))?result:-1;
    }// pageCombine
    
    private Integer pageCalculate(Integer page){
    	Integer digitAdd = (page/100) + ((page%100)/10) + (page%10);
    	Integer digitMultiplication = ((page/100==0) ? 1:page/100) * ((page%100)/10) * (page%10);
    	Integer result = (digitAdd >= digitMultiplication)?digitAdd:digitMultiplication;
    	return result;
    }//pageCalculate
}// class