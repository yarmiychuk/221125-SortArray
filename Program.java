import java.util.Arrays;
import java.util.Random;

// Реализовать алгоритм сортировки массива слиянием

public class Program {

    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 20;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {      
        int[] array = createArray();
        printArray("Исходный массив:", array);
        array = sortArray(array, 0, array.length - 1);
        printArray("Отсортированный массив:", array);
    }

    public static int[] createArray() {
        Random r = new Random();
        int size = r.nextInt(MIN_SIZE, MAX_SIZE);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(MAX_NUMBER + 1);
        }
        return arr;
    }

    public static void printArray(String message, int[] array) {
        message += "\n[";
        for (int i = 0; i < array.length; i++) {
            message += array[i];
            if (i < array.length - 1) {
                message += ", ";
            }
        }
        message += "]";
        System.out.println(message);
    }

    public static int[] sortArray(int[] array, int first, int last) {
        if (last <= first)
            return array;
        int middle = first + (last - first) / 2;
        sortArray(array, first, middle);
        sortArray(array, middle + 1, last);

        int[] temp = Arrays.copyOf(array, array.length);

        for (int k = first; k <= last; k++)
            temp[k] = array[k];

        int i = first, j = middle + 1;
        for (int k = first; k <= last; k++) {
            if (i > middle) {
                array[k] = temp[j];
                j++;
            } else if (j > last) {
                array[k] = temp[i];
                i++;
            } else if (temp[j] < temp[i]) {
                array[k] = temp[j];
                j++;
            } else {
                array[k] = temp[i];
                i++;
            }
        }
        return array;
    }
}