package chapter05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class Prob099 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        Melon melon1 = new Melon("good", 10);
        Melon melon2 = new Melon("bad", 20);
        Melon melon3 = new Melon("not bad", 20);

        Melon[] melons = {melon1, melon2, melon3};

        Arrays.sort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon o1, Melon o2) {
                return Integer.compare(melon1.getWeight(), melon2.getWeight());
            }
        });

        Arrays.sort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon o1, Melon o2) {
                return (-1) * Integer.compare(melon1.getWeight(), melon2.getWeight());
            }
        });

        Arrays.sort(melons, (o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));

        /*배열에는 원소를 병렬로 정렬하는 parallelSort() 메서드도 있다
         * 내부에서는 ForkJoinPool에 기반한 병렬 정렬-병합(sort-merge)라는 정렬 알고리즘을 사용하는데
         * 이 방법은 배열을 정렬된 하위 배열로 쪼개어 병합한다*/
        Arrays.parallelSort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon o1, Melon o2) {
                return Integer.compare(melon1.getWeight(), melon2.getWeight());
            }
        });

        Integer[] integers = new Integer[]{3, 1, 5};
        Arrays.sort(integers);
        Arrays.sort(integers, Collections.reverseOrder());

        Arrays.sort(integers);
        for (int leftHead = 0, rightHead = integers.length; leftHead < rightHead; leftHead++, rightHead--) {
            int element = integers[leftHead];
            integers[leftHead] = integers[rightHead];
            integers[rightHead] = element;
        }

        int[] ints = {2, 3, 4};


        int[] descIntegers = Arrays.stream(ints)
                .boxed()
                .sorted((o1, o2) -> Integer.compare(o2, o1))
                .mapToInt(Integer::intValue)
                .toArray();

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        Comparator<Melon> byType2 = Comparator.comparing(Melon::getType).reversed();
        Comparator<Melon> byType3 = Comparator.comparing(Melon::getType)
                .thenComparing(Melon::getWeight);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static <T> void bubbleSortWithComparator(
            T[] arr, Comparator<? super T> comparator
    ) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public static <T> void insertionSortWithComparator(
            T[] arr, Comparator<? super T> comparator
    ) {
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }

    }

    public static void countingSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] counts = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] - min]++;
        }

        int sortedIndex = 0;

        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[sortedIndex++] = i + min;
                counts[i]--;
            }
        }
    }

    public static void heapSort(int[] arr) {
        int length = arr.length;

        buildHeap(arr, length);

        while (length > 1) {
            swap(arr, 0, length - 1);
            length--;
            heapify(arr, length, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int greater;

        if (left < n && arr[left] > arr[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && arr[right] > arr[greater]) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, i);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void shuffleInt(int[] arr) {
        int index;
        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(arr, index, i);
        }
    }
}
