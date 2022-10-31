package onboarding;

class tsn_game{
	
	int tsn = 0;
	int clap = 0;
	
	tsn_game(){
	}
	
	tsn_game(int n){
		this.tsn = n;
	}
	
	int tsn_calc() {
		int i, temp;
		
		for(i = 1; i <= tsn; i++) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				clap++;
			}
			if(i/10 == 3 || i/10 == 6 || i/10 == 9) {
				clap++;
			}	
		}
		return clap;
	}
}


public class Problem3 {
    public static int solution(int number) {      
        tsn_game g = new tsn_game(number);
        
        
        if(number >= 1 && number <= 10000) {
        	return g.tsn_calc();
        }
        return 0;
    }
}
