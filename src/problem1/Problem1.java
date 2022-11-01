package problem1;

import java.util.List;

public class Problem1 {
	 public static int solution(List<Integer> pobi, List<Integer> crong) {
		 int result = 0;

	     int pobiScore = getScore(pobi);
	     int crongScore = getScore(crong);

	     if(pobiScore > crongScore) result = 1;
	     if(pobiScore < crongScore) result = 2;

	     try{
	    	 continousPage(pobi);
	    	 continousPage(crong);
	     } catch (IllegalArgumentException e){
	         return -1;
	     }        
	     return result;
	 }

	 private static int getScore(final List<Integer> pages){
	        int left = Math.max(plusPage(pages.get(0)),multiplePage(pages.get(0)));
	        int right = Math.max(plusPage(pages.get(1)),multiplePage(pages.get(1)));

	        return Math.max(left, right);
	 }
	 

	 private static int plusPage(int page){
	        int plus = 0;
	        while(page > 0){
	            plus += page % 10;
	            page /= 10;
	        }
	        return plus;
	 }

	 private static int multiplePage(int page){
	        int multiple = 1;
	        while(page > 0){
	            multiple *= page % 10;
	            page /= 10;
	        }
	        return multiple;
	 }

	 // 예외사항
	 private static void continousPage(final List<Integer> pages){
	        if(pages.get(0)+1 != pages.get(1))
	        	throw new IllegalArgumentException();
	 }
}
