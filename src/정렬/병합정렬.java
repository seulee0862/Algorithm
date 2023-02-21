package 정렬;

/**
 *  최악, 평균, 최고의 상황에서 nLogn의 시간복잡도를 보이는 최상위 정렬!
 */
public class 병합정렬{

    public static void main(String[] args) {
        int[] arr = {5 , 2, 3, 30, 10};
        병합정렬 main = new 병합정렬();
        main.mergeSort(arr, 0, arr.length-1);

        for (int x : arr) System.out.print(x+" ");
    }

    /**
     *  먼저 병합정렬을 하기위해 배열을 계속 나눈다
     *  그리고 왼쪽부터 병합하기 시작한다.
     */
    public void mergeSort(int[] arr, int l, int r) {

        if (l < r) {
            int middle = (l+r) / 2;

            mergeSort(arr, l, middle);
            mergeSort(arr, middle+1, r);

            merge(arr, l, middle, r);
        }
    }

    public void merge(int[] arr, int l, int middle, int r) {
        int i = l;
        int j = middle + 1;
        int k = l; // sorted[]의 index값
        int[] sorted = new int[arr.length];

        //왼쪽부터 중간까지, 중간다음부터 오른쪽 끝까지 비교하며 sotred에정렬
        while( (i <= middle) && (j <= r)) {
            if (arr[i] < arr[j]) {
                sorted[k] = arr[i];
                k++;
                i++;
            }
            else {
                sorted[k] = arr[j];
                k++;
                j++;
            }
        }

        /**
         * 모든 정렬이 끝나고나면 더 큰값을 가지고있는 쪽이 남아있다.
         * 왼쪽이 중간까지 도달하지 못했거나
         * 중간다음지점이 오른쪽까지 도달하지 못했다.
         *
         * 가장 작은단위부터 병합하고 있었기때문에 남은쪽은
         * 당연히 오름차순 정렬이 되어있는 상태이고 그렇기 때문에 남은값을
         * 순차적으로 sorted[]에 넣어주면 soroted[]는 arr[]이 정렬된 형태이다
         */
        while (i <= middle) {
            sorted[k] = arr[i];
            k++;
            i++;
        }
        while (j <= r) {
            sorted[k] = arr[j];
            k++;
            j++;
        }

        /**
         * arr[]로 정렬된 값을 정리해주면 된다.
         * 분할해서 왼쪽부터 합쳐 나가기 때문에 앞으로
         * 진행해갈 병합정렬에 영향을 끼치지 않는다.
         */
        for (int p=l; p<=r; p++) {
            arr[p] = sorted[p];
        }
    }
}