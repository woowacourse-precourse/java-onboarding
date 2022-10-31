package onboarding;

public class Problem3 {
    public static int solution(int number) {
    	int count = 0;
		
		for(int i = 1; i <= number; i++)
		{
			int bak_i	= i;
			
			while (bak_i != 0)
			{
				//3,6,9 에서 손벽을 침
				if (bak_i % 10 == 3 || bak_i % 10 == 6 || bak_i % 10 == 9)
					count++;
				bak_i /= 10;
			}
		}
		
		return count;
    }
}
