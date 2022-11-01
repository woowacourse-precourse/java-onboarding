////
public class Prob2 {
	
	public String delRep(String s) {
		int chk = 0;
		StringBuffer str = new StringBuffer(s);
		for(int i=0; i < str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				//System.out.println(str.charAt(i+1));
				str.delete(i, i+2);
				i--;
				chk++;
			}
		}
		//System.out.println("-> "+str);
		s = str.toString();
		if( chk !=0 ) { s = delRep(s); }
		return s;
	}

	public static void main(String[] args) {
		System.out.println("Problem2");
		
		Prob2 prob2 = new Prob2();
		
		String s = "browoanoommnaon";
		//String s = "zyelleyz";
		
		String result = prob2.delRep(s);
		System.out.println("\""+ result + "\"");
	}
}
