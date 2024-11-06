import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	final static  long mod = 1000000000;
	//memoization
	static Long[][] dp;
	static Integer len;
	static long recur(int digit, int value) {
		
		//첫쨰 자릿수에 도달하면 탐색할 필요가 없다.
		if(digit == 1) {
			return dp[digit][value];
		}
		
		//해당 자리수의 value값에 대해 탐색하지 않았을 경우
		if(dp[digit][value] == null) {
			if(value == 0) {
				dp[digit][value] = recur(digit-1,1);
			}
			else if (value == 9) {
				dp[digit][value] = recur(digit-1,8);
			}
			else {
				dp[digit][value] = recur(digit-1,value+1)+recur(digit-1,value-1);
			}
		}
		
		return dp[digit][value]%mod;
		
		
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		//123456이면 1은 마지막 자릿수, 6은 첫번째 자릿수로 고려한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//len은 구하는 값의 자릿수를 의미한다.
		int len = Integer.parseInt(br.readLine());
		
		//2차원 배열을 활용할것이다.
		dp= new Long[len+1][10];
		
		//자릿수가 1개인 녀석 > 이녀석은 0 부터 9까지 - 총 10개.
		for(int i=0; i<10; i++) {
			dp[1][i] = (long)1;
		}
		
		
		
		long result = 0;
		
		//마지막 자릿수. (얘는 1부터 9 ) 0이  들어가면 안되니까.
		for(int i=1; i<=9; i++) {
			//System.out.println(recur(len,i));
			result += recur(len,i);
		}
		System.out.println(result%mod);
		
		
		

	}

}
