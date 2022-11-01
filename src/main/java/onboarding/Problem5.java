package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) { // 50000�� ���� ����� ���� ���� �������� ���� ������
    	List<Integer> answer = new ArrayList<Integer>(9);
        int temp = money;
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i : arr) {
        	answer.add((int) temp / i);
        	temp = temp % i;
        }
        return answer;
    }
}
