package onboarding;

public class Problem3 { // n�� ���� �ݺ��Ͽ� ���̿� 3,6,9�� �� ���� ������ ���� ����
    public static int solution(int number) {
    	int answer = 0; // �� �ڼ� Ƚ��
    	for (int i = 1; number >= i;i++) {
    		String temp = String.valueOf(i); // ���� �ָ��� ���ڸ� ���ڷ�
    		temp = temp.replaceAll("[0124578]", ""); // ���Խ����� 3,6,9�� ����
    		answer = answer + temp.length();
    	}
        return answer;
    }
}
