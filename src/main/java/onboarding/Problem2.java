package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        
        StringBuffer sb = new StringBuffer(cryptogram);
		int num = 0;
		inf: while (sb.length()>0) {
			for (int i = 0; i < sb.length() - 1; i++) {
				num = 0;
				if (sb.charAt(i) == sb.charAt(i + 1)) {
					sb.delete(i, i + 2);
					num++;
					continue inf;
				}

			}
			if (num == 0) {
				break inf;
			}
		}
		String answer =  "\"" + sb.toString() + "\"";
        
        return answer;
    }
}
