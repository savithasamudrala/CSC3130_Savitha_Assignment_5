import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;

public class Hashmaps {
    public static void radixSort(String[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int max = 0;
        for (String s : arr) {
            max = Math.max(max, s.length());
        }

        for (int i = max - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    public static void countingSort(String[] arr, int i) {
        HashMap<Character, ArrayList<String>> map = new HashMap<>();

        for (char c = 'A'; c <= 'z'; c++) {
            map.put(c, new ArrayList<>());
        }

        for (String s : arr) {
            if (s.length() > i) {
                map.get(s.charAt(i)).add(s);
            } else {
                map.get('a').add(s);
            }
        }

        int index = 0;
        for (char c = 'A'; c <= 'z'; c++) {
            ArrayList<String> bucket = map.get(c);
            for (String s : bucket) {
                arr[index++] = s;
            }
        }
    }

    public static String subInt(int[] s, int[] t){
        Hashtable <Integer, Integer> subset = new Hashtable<>();

        for(int i = 0; i < t.length; i++){
            subset.put(i, t[i]);
        }
        for(int j : s){
            if(!subset.contains(j)){
                return "No";
            }
        }
        return "Yes";

    }

    public static int[] sumTarget(int[] A, int k){
        int sub = 0;
        int[] arr = {-1, -1};
        int j = 0;

        for(int i = 0; i < A.length; i++) {
            sub += A[i];
            while (sub > k) {
                sub -= A[j];
                j++;
            }
            if (sub == k) {
                arr[0] = j;
                arr[1] = i;
                return arr;
            }
        }

        for(int m = 0; m < A.length; m++){
            sub = A[m];
            if(sub == k){
                arr[0] = m;
                arr[1] = m;
                return arr;
            }
        }
        return arr;
    }


        public static void main(String[] args) {
            //Radix Sort
            System.out.println("Radix Sort:");
            String[] input = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman", "hydra", "surtr"};
            System.out.println("Input: " + Arrays.toString(input));
            radixSort(input);
            System.out.println("Output: " + Arrays.toString(input));

            System.out.println("EC: Uppercase Letters: ");
            String[] input2 = {"gojo", "gOogle", "Jogo", "bill"};
            System.out.println("Input: " + Arrays.toString(input2));
            radixSort(input2);
            System.out.println("Output: " + Arrays.toString(input2));


            //Sub-integer
            System.out.println("\nSub-integer:");
            int[] sub1 = {32, 3};
            int[] sub2 = {1, 2, 3, 52, 32, 54};

            int[] sub3 = {89, 32, 54, 32, 3};
            int[] sub4 = {54, 32, 99};

            System.out.println("S:" + Arrays.toString(sub1) + ", T:" + Arrays.toString(sub2));
            System.out.println("Output: " + subInt(sub1, sub2));
            System.out.println("S:" + Arrays.toString(sub3) + ", T:" + Arrays.toString(sub4));
            System.out.println("Output: " + subInt(sub3, sub4) + "\n");


            //EC: Subarray
            System.out.println("EC: Subarray:");
            int a[] = {1,2,3,7,5};
            int k1 = 12;
            int k2 = 5;
            int k3 = 7;
            int k4 = 11;

            System.out.println("Array: [1,2,3,7,5], K-values: 12, 5, 7, 11\nOutput:");
            System.out.println(Arrays.toString(sumTarget(a, k1)));
            System.out.println(Arrays.toString(sumTarget(a, k2)));
            System.out.println(Arrays.toString(sumTarget(a, k3)));
            System.out.println(Arrays.toString(sumTarget(a, k4)));

        }
}