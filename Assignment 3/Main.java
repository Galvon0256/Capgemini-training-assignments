import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();
        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(1);

        System.out.println("Before sorting:");
        for (int i = 0; i < arr.len(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        arr.sort(0, arr.len() - 1);

        System.out.println("After sorting:");
        for (int i = 0; i < arr.len(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        int searchVal = 3;
        int index = arr.search(searchVal);
        if (index != -1) {
            System.out.println("Element " + searchVal + " found at index: " + index);
        } else {
            System.out.println("Element " + searchVal + " not found.");
        }

        System.out.println("Popping back: " + arr.pop_back());
        System.out.println("Size after pop: " + arr.len());
    }

    static class MyArrayList {
        private Integer[] data;
        private int size;
        private int maxLength = 100000;
        private boolean isSorted = false;

        MyArrayList() {
            data = new Integer[maxLength];
            size = 0;
        }

        public void add(Integer val) {
            if (size == maxLength) resize();
            data[size++] = val;
            isSorted = false;
        }

        public Integer get(int idx) {
            return data[idx];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int search(Integer val) {
            if (isSorted) {
                int l = 0, r = size - 1;

                while (l <= r) {
                    int m = (l + r) / 2;

                    if (data[m] == val) return m;
                    else if (data[m] < val) l = m + 1;
                    else r = m - 1;
                }
                return -1;
            }

            for (int i = 0; i < size; i++) {
                if (data[i] == val) return i;
            }
            return -1;
        }

        public Integer pop_back() {
            if (isEmpty()) throw new EmptyStackException();

            Integer item = data[size - 1];
            data[size - 1] = null;
            size--;
            return item;
        }

        void merge(Integer a[], int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            Integer[] L = new Integer[n1];
            Integer[] R = new Integer[n2];

            for (int i = 0; i < n1; i++)
                L[i] = a[l + i];

            for (int j = 0; j < n2; j++)
                R[j] = a[m + 1 + j];

            int i = 0, j = 0;
            int k = l;

            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    a[k] = L[i];
                    i++;
                } else {
                    a[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                a[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                a[k] = R[j];
                j++;
                k++;
            }
        }

        void sort(int l, int r) {
            if (l < r) {
                int m = (l + r) / 2;

                sort(l, m);
                sort(m + 1, r);

                merge(data, l, m, r);
                isSorted = true;
            }
        }

        private void resize() {
            Integer[] newData = new Integer[maxLength * 2];

            for (int i = 0; i < maxLength; i++)
                newData[i] = data[i];

            maxLength *= 2;
            data = newData;
        }

        public int len() {
            return size;
        }
    }
}
