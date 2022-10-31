package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		answer = getGameResult(pobi, crong);
		
		
		
		return answer;
	}

	

	/**
     * 게임 결과를 가져온다
     * @param 포비와 크롱의 페이지값
     * @return 게임 결과 (포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1)
     */
	 private static int getGameResult(List<Integer> pobi, List<Integer> crong) {
		 int answer = Integer.MAX_VALUE;
		 try {
				validityCheck(pobi);
				validityCheck(crong);
				
				int pobiScore = findMax(pobi);
				int crongScore = findMax(crong);
				answer = pobiScore == crongScore ? 0 : (pobiScore > crongScore ? 1 : 2);
				
			} catch (Exception e) {
				answer = -1;
			}
		return answer;
	}

	/**
     * 유효성 체크 및 오류처리
     * @param page값이 들어있는 List
     * @return 
     */
	private static void validityCheck(List<Integer> pages) throws Exception {
		
		if(pages.isEmpty()){
			throw new Exception("PagesInfo Is Empty");
		}
		if(pages.size()!=2) {
			throw new Exception("PagesInfo's Size is not 2");
		}
		if(pages.get(1)-pages.get(0) != 1) {
			throw new Exception("PagesInfo Is Wrong");
		}
		if(pages.get(0) == 0) {
			throw new Exception("PagesInfo Is Wrong");
		}
	}

	 /**
     * 두 페이지 중 더 높은 숫자를 찾는다.
     * @param page값이 들어있는 List
     * @return 계산결과가 높은 숫자
     */
	private static int findMax(List<Integer> pages) throws Exception {

		String leftPage = pages.get(0).toString();
		String rightPage = pages.get(1).toString();

		int leftMax = findMaxOfPlusAndMult(leftPage);
		int rightMax = findMaxOfPlusAndMult(rightPage);
		
		int pagesMax = leftMax > rightMax ? leftMax : rightMax;
		
		return pagesMax;
	}

	 /**
     * 두 계산식 중 더 높은 숫자를 찾는다.
     * @param page값
     * @return 더하기 or  곱셈 중 계산결과가 높은 숫자
     */
	private static int findMaxOfPlusAndMult(String page) throws Exception {
		
		
		int pageInt = Integer.parseInt(page);
		
		int plus = 0;
		int multi = 1;
		
		while(pageInt > 0){
			plus += pageInt%10;
			multi *= pageInt%10;
			pageInt = pageInt/10;	
		}
		return plus > multi ?  plus : multi;
	}
	

}
