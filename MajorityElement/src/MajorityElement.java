import java.util.HashMap;

/**
 * Created by Mengqi on 15/1/27.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int []num = {8,8,7,7,7};

        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(num));
    }
    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        //纪录各元素频率
        HashMap<Integer, Integer> eleFreq = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (eleFreq.get(num[i]) == null) {
                eleFreq.put(num[i], 1);
            } else {
                int newFreq = eleFreq.get(num[i])+1;
                if (newFreq > num.length/2) {
                    return num[i];
                }
                eleFreq.put(num[i],newFreq);
            }
        }
        return -1;
    }
}
