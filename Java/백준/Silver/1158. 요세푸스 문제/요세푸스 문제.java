
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int count = Integer.parseInt(arr[1]);
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			deq.addLast(i);
		}
		while(!deq.isEmpty()) {
			//count-1번 반복
			for(int i=1; i<count; i++) {
				if(!deq.isEmpty()) {
					deq.addLast(deq.poll());
				}
				
			}
			if(deq.size() == 1) {
				sb.append(deq.poll());
			}
			else {
				sb.append(deq.poll()+", ");
			}
			
		}
		sb.append(">");
		System.out.println(sb);
	

	}

}