package onboarding;

class tsn_game{
	
	int tsn = 0;
	int clap = 0;
	
	tsn_game(){
	}
	
	tsn_game(int n){
		this.tsn = n;
	}
	
	int tsn_one() {
		int i;
	
		for(i = 1; i <= tsn; i++) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				clap++;
			}
		}
		return clap;
	}
	
	int tsn_ten() {
		int i;
		
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
	int tsn_hund() {
		int i;
		
		for(i = 1; i <= tsn; i++) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				clap++;
			}
			if(i / 10 % 10 == 3 || i / 10 % 10 == 6 || i / 10 % 10 == 9) {
				clap++;
			}	
			if(i / 100 == 3 || i / 100 == 6 || i / 100 == 9) {
				clap++;
			}
		}
		return clap;
	}
	
	int tsn_thous(){
		int i;
		
		for(i = 1; i <= tsn; i++) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				clap++;
			}
			if(i / 10 % 10 == 3 || i / 10 % 10 == 6 || i / 10 % 10 == 9) {
				clap++;
			}	
			if(i / 100 % 10== 3 || i / 100 % 10== 6 || i / 100 % 10== 9) {
				clap++;
			}
			if(i / 1000 == 3 || i / 1000 == 6 || i / 1000 == 9) {
				clap++;
			}
		}
		return clap;
	}
	
	int tsn_calc() {
		if(tsn >= 1 && tsn < 10) {
			return tsn_one();
		}
		else if(tsn >= 10 && tsn < 100) {
			return tsn_ten();
		}
		else if(tsn >= 100 && tsn < 1000) {
			return tsn_hund();
		}
		else if(tsn >= 1000 && tsn < 10000) {
			return tsn_thous();
		}
		else
			return 0;
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
