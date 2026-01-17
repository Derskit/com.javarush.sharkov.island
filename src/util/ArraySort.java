package util;

public class ArraySort {
    public static Object[][] sort(Object[][] array, int internalIndex) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if ((int) array[i][internalIndex] < (int) array[i - 1][internalIndex]) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }
        return array;
    }

    private static void swap(Object[][] array, int ind1, int ind2) {
        Object[] tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
