package onboarding;

import java.util.List;

class Problem1 {
	
	public static boolean exceptionRaised(List<Integer>pobi, List<Integer> crong)
	{
		/*
		 * 왼쪽 페이지가 오른쪽 페이지와 1장이상 차이나거나
		 * 왼쪽페이지가 짝수이거나 오른쪽 페이지가 홀수이거나
		 * 왼쪽이나 오른쪽 페이지가 0이하이거나 400이상이면
		 * 
		 * -1 리턴
		 * */
		if(pobi.get(0) - pobi.get(1) != -1)
			return true;
		
		if(pobi.get(0) % 2 == 0)
    		return true;
    	if(pobi.get(1) % 2 == 1)
    		return true;
		
    	if(pobi.get(0) <= 0 && pobi.get(0) >= 400)
    		return true;
    	if(pobi.get(1) <= 0 && pobi.get(1) >= 400)
    		return true;
    		
    	
    	
    	if(crong.get(0) - crong.get(1) != -1)
			return true;
		
		if(crong.get(0) % 2 == 0)
    		return true;
    	if(crong.get(1) % 2 == 1)
    		return true;
		
    	if(crong.get(0) <= 0 && crong.get(0) >= 400)
    		return true;
    	if(crong.get(1) <= 0 && crong.get(1) >= 400)
    		return true;
    	
    	
    	return false;
    	
	}
	public static int getMaxScore(int player_score)
	{
		int page_plus_score 	= 0;
		int page_mul_score		= 1;
		int bak_player_score	= player_score;
		
		while (bak_player_score != 0)
		{
			page_plus_score		+= bak_player_score % 10;
			page_mul_score		*= bak_player_score % 10;
			bak_player_score	/= 10;
		}
		
		if (page_plus_score <= page_mul_score)
			return page_mul_score;
		else
			return page_plus_score;
	}
	
	
	//왼쪽 오른쪽 페이지를 비교하고 큰것을 반환
	static public int getScore(int left_page, int right_page)
	{
		int left_page_score 	= 0;
		int right_page_score	= 0;
		
		left_page_score		= getMaxScore(left_page);
		right_page_score	= getMaxScore(right_page);
		
		if (left_page_score <= right_page_score)
			return right_page_score;
		else
			return left_page_score;
	}
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        
    	if (exceptionRaised(pobi, crong) == true)
    		return -1;    	
        
        int	left_page_of_pobi	= pobi.get(0);
        int right_page_of_pobi	= pobi.get(1);
        
        int left_page_of_crong	= crong.get(0);
        int right_page_of_crong	= crong.get(1);
        
		int score_of_pobi	= getScore(left_page_of_pobi, right_page_of_pobi);
		int score_of_crong	= getScore(left_page_of_crong, right_page_of_crong);
		
		if (score_of_crong < score_of_pobi)
			return 1;
		else if (score_of_pobi < score_of_crong)
			return 2;
		else
			return 0;

    }
}