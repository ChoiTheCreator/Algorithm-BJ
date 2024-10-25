import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstSetLength = Integer.parseInt(st.nextToken());
        int secondSetLength = Integer.parseInt((st.nextToken()));


        st = new StringTokenizer(br.readLine());
        Set<Integer> first = new HashSet<>();
        for(int i=0; i<firstSetLength; i++ ){
            first.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        Set<Integer> second = new HashSet<>();
        for(int i=0; i<secondSetLength; i++ ){
            second.add(Integer.parseInt(st.nextToken()));
        }

        //두개를 더해버림 (addAll)
       first.addAll(second);

        int sumSetLength = first.size();

        // first - second Length
       int first_secound= sumSetLength-secondSetLength;

       //second - first length
        int second_first = sumSetLength-firstSetLength;
        System.out.println(first_secound+second_first);

    }

}
