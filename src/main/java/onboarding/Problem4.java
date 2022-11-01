package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	String answer = "";
    	String temp = word.toLowerCase(); // �켱 ��� �ҹ��ڷ� ����
    	String alpha = "abcdefghijklmnopqrstuvwxyz"; // �쿵��� �Ųٷ� �ص� �쿵��
    	for (int i=0;i<temp.length();i++) {
    		boolean upper = false;
    		char c = temp.charAt(i);
    		if (Character.isUpperCase(word.charAt(i))) { // �빮������ Ȯ��
    			upper = true;
    		}
    		int idx = alpha.indexOf(c); // ǥ������ �ε���
    		
    		if ((int)c >= 97 && (int)c <= 122) { // ���ĺ��� ��쿡�� ��ȯ
    			c = alpha.charAt((alpha.length() - 1) - idx);
    			if (upper) {
    				answer = answer + Character.toUpperCase(c);
    			}
    			else {
    				answer = answer + c; // �ش� ���ĺ��� �ε����� �̿��� ��ȯ					
				}
    		}
    		else {
				answer = answer + c;
			}
    		
    		
    	}
    	
        return answer;
    }
}
