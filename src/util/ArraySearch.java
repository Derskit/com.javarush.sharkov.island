package util;

public class ArraySearch {
    public static int externalIndex(Object[][] arr, Object o, int internalIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][internalIndex].equals(o)) {
                return i;
            }
        }
        return 0;
    }
}
