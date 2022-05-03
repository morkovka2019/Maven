package generics;

import java.util.*;

public class Converter {
    private List<Number> converteredList = new ArrayList<>();


    public void numericArrayToList( int[] arrayToConv ) {
        for (int i=0; i<arrayToConv.length; i++) {
            converteredList.add(arrayToConv[i]);
        }
    }

    public List<Number> getList() {
        return this.converteredList;
    }

    public void printList( List listToPrint ) {
        for (int i=0; i < listToPrint.size(); i++) {
            System.out.println(listToPrint.get(i));
        }
    }

    public int[] fillTheListCreation(int[] list, int s) {
        Random random = new Random();
        for (int k = 0; k < s; k++) {
            list[k] = random.nextInt(9);
        }
        return list;
    }
    public static void main(String[] args) {
        Converter converter = new Converter();
        int size = 7;
        int[] myArray = new int [size];

        converter.fillTheListCreation(myArray, size);
        converter.numericArrayToList(myArray);
        converter.printList(converter.getList());
    }
}
