package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	
    	//exception
    	if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0 
    			|| pobi.get(0) + 1 != pobi.get(1)|| crong.get(0) + 1 != crong.get(1)) 
    		return -1;
        
    	// init
    	int[][] pobiScore = new int[2][2];
        int[][] crongScore = new int[2][2];
        
        pobiScore[0] = calculate_page(pobi.get(0));
        pobiScore[1] = calculate_page(pobi.get(1));

        crongScore[0] = calculate_page(crong.get(0));
        crongScore[1] = calculate_page(crong.get(1));

        int pobiMax = Math.max(Math.max(pobiScore[0][0], pobiScore[0][1]), Math.max(pobiScore[1][0], pobiScore[1][1]));
        int crongMax = Math.max(Math.max(crongScore[0][0], crongScore[0][1]), Math.max(crongScore[1][0], crongScore[1][1]));


        if (pobiMax > crongMax) return 1;
        if (pobiMax < crongMax) return 2;
        return 0;

    }
    
    private static int[] calculate_page(int page) {
        int sum = 0, mul = 1;

        for (int i = page; i > 0; i /= 10) {
            int cur = i % 10;
            sum += cur;
            mul *= cur;
        }

        return new int[]{sum, mul};
    }
}