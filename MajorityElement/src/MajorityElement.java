/**
 * Created by Mengqi on 15/1/27.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] num = new int[]{4, 3, 3, 2, 2};
        System.out.println(MajorityElement.majorityElement(num)+"!");
    }

    public static int majorityElement(int[] num) {
        quicksort(num, 0, num.length - 1);
        return num[num.length/2];
    }

    public static void quicksort(int[] num, int left, int right) {
        if (left < right) {
            int i = left - 1 + 1; //i从left前一个位置开始，但由于left处的值就是pivot，所以向后一个位置
            int j = right + 1;
            int pivot = num[left];
            while (true) {
                //确保左边的数都 <= pivot
                while (i + 1 < right+1 && num[++i] <= pivot) ;

                //确保右边的数都 >= pivot
                while (j - 1 > left-1 && num[--j] >= pivot) ;

                //pivot左边均已为比它小的数
                //pivot右边均已为比它大的数
                if (i >= j) {
                    break;
                }
                //走到这一步说明
                //num[i] > pivot
                //num[j] < pivot
                //将两数互换
                swap(num, i, j);
            }
            swap(num, left, j);//将pivot移到中间
            quicksort(num, left, j - 1);
            quicksort(num, j + 1, right);
        } else {
            return;
        }
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
