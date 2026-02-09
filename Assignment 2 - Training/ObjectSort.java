package assignment2;
class Student1{
    String name;
    int rollNo;
    Student1(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
}
public class ObjectSort {
    static void ObjectSorting(Student1[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].rollNo >= arr[j + 1].rollNo) {
                    if (arr[j].rollNo == arr[j + 1].rollNo && arr[j].name.compareTo(arr[j + 1].name) < 0) {
                        continue;
                    }
                    Student1 temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    static void printObjectArray(Student1[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i].name + " " + arr[i].rollNo);
        }
    }

    static void main(String[] args) {
        Student1[] arr2 = {
                new Student1("Tanmay",2),
                new Student1("Amaan", 3),
                new Student1("Tanush",1),
                new Student1("Ankur",1),
                new Student1("Shresth",2),

        };
        ObjectSorting(arr2);
        printObjectArray(arr2);
    }
}
