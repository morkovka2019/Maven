package generics;
import java.util.*;

public class Converter {
    private static List<Number> converteredList = new ArrayList<>();


    public static void numericArrayToList( int [] arrayToConv ) {
        for (int i=0; i<arrayToConv.length; i++) {
            converteredList.add(arrayToConv[i]);
        }
    }

    public static List getList() {
        return converteredList;
    }

    public static void printList( List listToPrint ) {
        for (int i=0; i < listToPrint.size(); i++) {
            System.out.println(listToPrint.get(i));
        }
    }

    public static int[] fillTheListCreation(int[] list, int s) {
        Random random = new Random();
        for (int k = 0; k < s; k++) {
            list[k] = random.nextInt(9);
        }
        return list;
    }
    public static void main(String[] args) {
        int size = 7;
        int[] myArray = new int [size];

        fillTheListCreation(myArray, size);
        numericArrayToList(myArray);
        printList(getList());
    }
}
