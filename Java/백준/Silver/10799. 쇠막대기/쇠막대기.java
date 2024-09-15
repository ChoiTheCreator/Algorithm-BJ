import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Stack<Character> stack = new Stack<>();

        int ans = 0;

        //어차피 첫번째 인덱스가 ) 일 가능성은 없다
        for(int i=0; i<st.length(); i++){
            if(st.charAt(i) == '('){
                stack.push('(');
            }
            else if (st.charAt(i) == ')'){
                if(st.charAt(i-1) == '('){
                    stack.pop();
                    ans += stack.size();
                }
                if(st.charAt(i-1) == ')'){
                    ans+=1;
                    stack.pop();
                }
            }
        }

        System.out.println(ans);
    }
}
