package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = clapCount(number);

		return answer;
	}

	private static int numberCount(int num) {
		int n = 0;

		while(num > 0) {
			n++;
			num /= 10;
		}

		return n;
	}

	private static int maxNumber(int num, int length) {
		int div = 1;

		for(int i = 0;i < length - 1;i++)
			div *= 10;

		return num / div;
	}

	private static int pow(int under, int top) {
		int ret = 1;

		for(int i = 0;i < top;i++)
			ret *= under;

		return ret;
	}

	private static int combination(int n, int r) {
		int ret = 1;

		for(int i = 0;i < r;i++)
			ret *= (n - i);
		for(int i = r;i > 1;i--)
			ret /= i;

		return ret;
	}

	private static int clapCount(int num) {
		return clapCount(num, false);
	}

	private static int clapCount(int num, boolean frontClap) {
		int clap = 0;
		int length = numberCount(num);
		int msNum = maxNumber(num, length);
		int msNumCount;

		// num이 0이고 앞자리 수가 3,6,9 중 하나라면 박수 1, 아니면 0
		if(num == 0)
			return frontClap ? 1 : 0;

		// 앞자리 수가 3,6,9 중 하나라면 num + 1만큼 박수 필요
		if(frontClap)
			clap += (num + 1);

		// 숫자 길이가 1이라면 3,6,9가 포함된 만큼만 박수 추가 후 리턴
		if(length == 1) {
			clap += (num / 3);
			return clap;
		}

		// 맨 왼쪽 숫자에 포함되는 3,6,9의 수 계산
		// (맨 왼쪽 숫자 - 1)의 3,6,9 포함 개수
		// 맨 왼쪽 숫자 자체는 뒤의 자리에 따라 수가 달라질 수 있으므로 -1
		// (ex. 6123인 경우 3000 ~ 3999까지 1000개의 3이 발생. 6은 124개가 발생하므로 -1로 제외)
		msNumCount = (msNum - 1) / 3;
		// 포함된다면 10^(숫자 길이 - 1)
		if(msNumCount > 0)
			clap += (pow(10, length - 1) * msNumCount);

		// 맨 왼쪽을 제외한 나머지 숫자들은 0 ~ 9까지 모든 숫자 사용가능
		// 3,6,9가 1개부터 나머지 숫자 길이만큼 사용되는 수 계산
		// 3,6,9가 사용되는 수 == i + 1
		// 3^(i + 1) + 7^(3,6,9가 아닌 나머지 숫자) * 위치에 따른 조합 * (i + 1) * 맨 왼쪽 숫자
		for(int i = 0;i < length - 1;i++)
			clap += ((pow(3, i + 1) * pow(7, length - i - 2)) * combination(length - 1, i + 1) * (i + 1) * msNum);

		// 맨 왼쪽 숫자가 3,6,9라면 true로 하여 재귀
		if(msNum % 3 == 0)
			frontClap = true;
		else
			frontClap = false;

		return clap + clapCount(num % pow(10, length - 1), frontClap);
	}
}
