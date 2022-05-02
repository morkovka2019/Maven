package generics;

import java.util.*;

public class Converter {
    private static List converteredList = new ArrayList<>();


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

    public static int[] feelTheListCreation(int[] list, int s) {
        Random random = new Random();
        for (int k = 0; k < s; k++) {
            list[k] = random.nextInt(9);
        }
        return list;
    }
    public static void main(String[] args) {
        int size = 9;
        int[] myArray = new int [size];

        feelTheListCreation(myArray, size);
        Converter.numericArrayToList(myArray);
        List myArList = Converter.getList();
        Converter.printList(myArList);
    }
}
