import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int swapCount = 0;  
    static int K;  // K번째 교환을 추적할 값

    // 배열을 분할하고 pivot을 기준으로 정렬
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // 피벗 값 설정 (마지막 원소)
        int i = low - 1;  // 작은 값들의 끝 인덱스

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);  // 작은 값 발견 시 교환
            }
        }
        if (i + 1 != high) swap(array, i + 1, high);  // 피벗 위치로 이동
        return i + 1;  // 피벗의 최종 위치 반환
    }

    // 두 원소를 교환하고 K번째 교환 시 값을 출력
    private static void swap(int[] array, int i, int j) {
        swapCount++;
        if (swapCount == K) {
            System.out.println(Math.min(array[i], array[j]) + " " + Math.max(array[i], array[j]));
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 선택 알고리즘 (퀵 셀렉트) 구현
    private static int select(int[] array, int low, int high, int target) {
        if (low == high) return array[low];  // 배열에 원소가 하나 남았을 때

        int pivotIndex = partition(array, low, high);  // 배열을 분할
        int order = pivotIndex - low + 1;  // 피벗의 순서 계산

        if (order > target) {
            return select(array, low, pivotIndex - 1, target);  // 왼쪽 배열 탐색
        } else if (order == target) {
            return array[pivotIndex];  // 피벗이 원하는 순서일 때
        } else {
            return select(array, pivotIndex + 1, high, target - order);  // 오른쪽 배열 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 배열 크기 n, 찾을 순서 q, K번째 교환 입력
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int targetOrder = Integer.parseInt(input[1]) - 1;  // 0-based 인덱스로 조정
        K = Integer.parseInt(input[2]);

        // 배열 입력 처리
        int[] array = new int[n];
        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }

        // 선택 알고리즘 호출
        select(array, 0, n - 1, targetOrder);

        // 교환 횟수가 K보다 적을 경우 -1 출력
        if (swapCount < K) System.out.println(-1);
    }
}