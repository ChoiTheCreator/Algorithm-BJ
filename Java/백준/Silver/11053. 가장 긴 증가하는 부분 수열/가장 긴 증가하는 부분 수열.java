import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] tmp= new int[n];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++) {
			tmp[i]= Integer.parseInt(st.nextToken());
		}
		
		//dp
		for(int i=0; i<n; i++) {
			dp[i] =1;
			
			// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
			//1. 일단 tmp now가 tmp 전 보다 커야함. 
			//2. 그리고 나서 dp now 보다 dp 전 +1 이 클 경우 dp값을 최신화.
			for(int j=0; j<i; j++) {
				if(tmp[j] < tmp[i] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		// 최댓값(최대 길이) 탐색 
				int max = -1;
				for(int i = 0; i < n; i++) {
					max = dp[i] > max ? dp[i] : max;
				}
				System.out.println(max);
		

	}

}