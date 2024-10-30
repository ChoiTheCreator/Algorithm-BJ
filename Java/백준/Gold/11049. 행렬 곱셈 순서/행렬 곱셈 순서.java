import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        //Input 받는 부분

        //P[] (차원배열 선언)
        //dp의 두가지 원칙
        // 1. dp[] -> 메모이제이션을 선언 (여기서는 cost라는 배열로 함)
        int cost[][] = new int[cnt][cnt];

        //matrix[x][0] => x번째 (전체 cnt 중)에서 행렬의 행의 크기
        //matrix[x][1] => x번째 (전체 cnt 중)에서 행렬의 열의 크기
        int matrix[][] = new int[cnt][2];

        //matrix의 행,렬의 값을 저장
        for(int i=0; i<cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                matrix[i][0] = Integer.parseInt(st.nextToken());
                matrix[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(calculateMin(matrix));

        //



    }

    private static int calculateMin(int[][] matrix){
        int size = matrix.length;

        int[][] cost = new int[size][size];
       //chain -> 1일때는 어차피 다 0임 (자기자신곱셈)
        for(int i=0; i<size; i++){
            cost[i][i]= 0;
        }

        //chain은 2부터 사이즈(전체크기) 까지 늘어나겠다.
        for(int chain =2; chain <= size; chain++){
            //자연스럽다. start (시작부분)은 전체크기-chain까지만 start 포인터가 움직일수있음
            for(int start =0; start<=size-chain; start++){
                //end pointer또한 마찬가지로, start+chain-1 이어야 정확히 겹쳐짐
                int end = start+chain-1;
                //Min을 계속 주입해야하므로, 가장 큰 값으로 초기화
                cost[start][end] = Integer.MAX_VALUE;

                //중간지점 k는 시작점 부터 - (end-1)까지 순회할수있다.
                for(int k= start; k<end; k++){
                    int middlePoint = cost[start][k] + cost[k+1][end]+(matrix[start][0]*matrix[k][1]*matrix[end][1]);
                    cost[start][end]=Math.min(cost[start][end],middlePoint);
                }
            }
        }
        //이게 최종답 행렬(0) 첫번째 행렬 부터 행렬(size-1) 마지막 행렬까지의 최소합
        return cost[0][size-1];

    }
}
