package onboarding;

import java.util.List;
//1.책을 임의로 펼쳤을 때 옳은 값이 들어왔는지 확인한다.
//  1-1. 왼쪽 페이지와 오른쪽 페이지의 숫자가 1차이 나는지 확인
//  1-2. 책의 처음이나 마지막 부분을 펼치지 않았는지 확인
//  1-3. 책을 펼쳤을 때 왼쪽은 홀수 오른쪽은 짝수 인지 확인
//2.왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//  2-1. 페이지 번호의 각 자리 숫자를 모두 더한다.
//  2-2. 페이지 번호의 각 자리 숫자를 모두 곱한다.
//3.오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//4.2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
//5.점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
//  5-1.포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성한다.
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //1.책을 임의로 펼쳤을 때 옳은 값이 들어왔는지 확인한다.
        //1-1.왼쪽 페이지와 오른쪽 페이지의 숫자가 1차이 나는지 확인
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1)
            return -1;
        //1-2.책의 처음이나 마지막 부분을 펼치지 않았는지 확인
        if(pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400)
            return -1;
        //1-3.책을 펼쳤을 때 왼쪽은 홀수 오른쪽은 짝수 인지 확인
        for(int i = 0; i < 2; i++)
        {
            if(i == 0)
                if(pobi.get(i) % 2 == 0 || crong.get(i) % 2 == 0)
                    return -1;
            else if(i == 1)
                if(pobi.get(i) % 2 != 0 || crong.get(i) % 2 != 0)
                    return -1;
        }
        Problem1 test = new Problem1();
        int[] pobi_arr = {0, 0};
        int[] crong_arr = {0, 0};
        int pobi_n, crong_n;

        //2.왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        //3.오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        for(int i = 0; i < 2; i++)
        {
            pobi_arr[i] = Math.max(test.sum_all(pobi.get(i)), test.times_all(pobi.get(i)));
            crong_arr[i] = Math.max(test.sum_all(crong.get(i)), test.times_all(crong.get(i)));
        }

        //4.2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
        pobi_n = Math.max(pobi_arr[0], pobi_arr[1]);
        crong_n = Math.max(crong_arr[0], crong_arr[1]);

        //5.점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        //5-1. 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성한다.
        if(pobi_n > crong_n)
            answer = 1;
        else if(pobi_n < crong_n)
            answer = 2;
        else
            answer = 0;
        return answer;
    }
    //2-1. 페이지 번호의 자리수를 모두 더한다.
    public int sum_all(int number){
        int sum_n = 0;
        while(number > 0)
        {
            sum_n += number % 10;
            number /= 10;
        }
        return sum_n;
    }
    //2-2. 페이지 번호의 자리수를 모두 곱한다.
    public int times_all(int number){
        int times_n = 1;
        while(number > 0)
        {
            times_n *= number % 10;
            number /= 10;
        }
        return times_n;
    }
}