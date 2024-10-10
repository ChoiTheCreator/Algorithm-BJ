import java.io.*;
import java.util.Collections;
import java.util.Vector;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Vector<Integer> vect = new Vector<Integer>();
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			vect.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(vect);
		for(int value: vect) {
			sb.append(value).append("\n");
			
		}
		System.out.println(sb);

	}

}
