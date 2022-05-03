package generics;

import java.util.*;

public class Converter {
    private List<Number> converteredList = new ArrayList<>();


    public void numericArrayToList( int[] arrayToConv ) {
        for (int i=0; i<arrayToConv.length; i++) {
            converteredList.add(arrayToConv[i]);
        }
    }

    public void numericArrayToList( Float[] arrayToConv ) {
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
        int size = 5;
        int[] myArray = new int [size];
        converter.fillTheListCreation(myArray, size);
        converter.numericArrayToList(myArray);

        Float[] myArr = new Float[]{22.3f, -44.8645645f, 0f, 1.8732e3f};
        converter.numericArrayToList(myArr);
        converter.printList(converter.getList());
    }
}
