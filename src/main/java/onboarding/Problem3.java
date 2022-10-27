package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for i in range(int number+1)[1:]: // 주어진 숫자만큼 1부터 올라가면서 3,6,9를 체크 
            num = str(i).split() // 2자리 수 이상에서 3,6,9가 여러개 나올 수 있어서 문자열로 치환해서 자릿수별로 나눔
            for j in num:
                if int(j) = 3 or 6 or 9: // 각 자릿수마다 3,6,9가 있는지를 체크 
                    answer += 1
        return answer;
    }
}
