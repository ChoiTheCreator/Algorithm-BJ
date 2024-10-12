import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    private static int[] tmp;        // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    /* 책이 나온대로 */
    private static void mergeBook(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int idx = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[idx++] = arr[i++];
            } else {
                tmp[idx++] = arr[j++];
            }
        }
        //왼쪽 부분정렬 배열이 남은 경우
        while (i <= mid) {
            tmp[idx++] = arr[i++];
        }
        //오른쪽 부분정렬 배열이 남은 경우
        while (j <= right) {
            tmp[idx++] = arr[j++];
        }

        //만들어준 tmp를 이제 arr배열에다 복사
        // tmp 배열의 내용을 원본 배열(arr)로 복사
        for (int k = left; k <= right; k++) {
            arr[k] = tmp[k];
        }

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left; //왼쪽 부분 리스트의 시작점
        int r = mid + 1; //오른쪽 부분 리스트의 시작점
        int idx = left; //채워놓은 배열의 인덱스

        while (l <= mid && r <= right) {
            /*
             *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
             */
            if (arr[l] <= arr[r]) {
                tmp[idx] = arr[l];
                l++;
                idx++;
            }
            /*
             * 오른쪽 부분리스트 r번째 원소가 부분리스트 l번째 원소보다 작거나 같은 경우
             * 오른쪽 r번쨰 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다 */
            else {
                tmp[idx] = arr[r];
                r++;
                idx++;
            }

        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if (l > mid) {
            while (r <= right) {
                tmp[idx] = arr[r];
                r++;
                idx++;
            }
        }
        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while (l <= mid) {
                tmp[idx] = arr[l];
                l++;
                idx++;
            }
        }
        /*
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
         */
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        /*
         * left == right 의 뜻은 시작과 끝이 같다는 의미이므로
         * 부분리스트의 원소의 갯수가 1개라는 뜻이다.
         * 더이상 쪼갤수없으므로 return.*/
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);


    }

    public static void mergeSort(int[] arr) {
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        tmp = null;
    }


    public static void main(String[] args) throws IOException {

        // 테스트용 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //GET INPUT BY TOKENIzer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        mergeSort(arr);
        System.out.println(arr[k-1]);
    }
}
