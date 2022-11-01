package onboarding;

public class prob1 {

	public int solution(int[] pobi, int[] crong) {
		boolean page = validation(pobi, crong);//å ���ܻ��� üũ
		if(!page) {
			return -1;
			//system.out.println("-1")
		}
		
		//������������
		int pobi_sum_score = sum(pobi);
		int pobi_mul_score = mul(pobi);
		
		int pobi_max_score = maxScore(pobi_sum_score, pobi_mul_score);
		
		
		//ũ�� ��������
		int crong_sum_score = sum(pobi);
		int crong_mul_score = mul(pobi);
			
		int crong_max_score = maxScore(crong_sum_score, pobi_mul_score);
		
		
		//��������
		if (pobi_max_score > crong_max_score) {
			return 1;
			//system.out.println("1");
		}else if (pobi_max_score < crong_max_score) {
			return 2;
			//system.out.println("2");
		}else if (pobi_max_score == crong_max_score) {
			return 0;
			//system.out.println("0");
			
		}else {
			return -1;
			//System.out.println("-1);
		}
		
		
	}
	
	/**
	 * ���� �ջ�
	 * @param value �迭
	 * @return
	 */
	static private int sum(int[] value) {
		
		int val_1 = 0;
		int val_2 = 0;
		
		String[] array1 = String.valueOf(value[0]).split("");
		for (String val : array1) {
			val_1 = val_1 + Integer.valueOf(val);
		}
		
		String[] array2 = String.valueOf(value[1]).split("");
		for (String val : array2) {
			val_2 = val_2 + Integer.valueOf(val);
		}
		
		return maxScore(val_1, val_2);
	}
	
		
	/**
	 * ���ϱ�
	 * @param value
	 * @return
	 */
	static private int mul(int value[]) {
		
		int val_1 = 1;
		int val_2 = 1;
		
		String[] array1 = String.valueOf(value[0]).split("");
		for (String val : array1) {
			val_1 = val_1 * Integer.valueOf(val); 
		}
		
		String[] array2 = String.valueOf(value[1]).split("");
		for (String val : array2) {
			val_2 = val_2 * Integer.valueOf(val); 
		}
		
		return maxScore(val_1, val_2);
	
	}
	
	/**
	 * �ְ����� ���
	 * @param a
	 * @param b
	 * @return
	 */
	static private int maxScore(int a, int b) {
		if (a>b) {
			return a;
		}else {
			return b;
		}
	}
	
	/**
	 * ���ܻ�Ȳ üũ - �迭�� 1���̰� �����Ѵ�
	 * @param pobi
	 * @param crong
	 * @return
	 */
	static private boolean validation(int[] pobi, int[] crong) {
		
		boolean result = true;
		
		if (1 != Math.abs(pobi[0] - pobi[1])) {
			return false;
		}else if (1 != Math.abs(crong[0] - crong[1])) {
			return false;
		}else {
			return result;
		}
		
	}

//��������� �����ִ� �� 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prob1 pb = new prob1();
		
		int[] a = {97, 98};
		int[] b = {197, 198};
		
		int c = pb.solution(a,b);
	
		System.out.println(c);
	}

}
