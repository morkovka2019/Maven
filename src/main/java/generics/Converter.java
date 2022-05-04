package generics;

import java.util.*;

public class Converter <T> {
    T[] arrayToConv;
    private List<T> converteredList = new ArrayList<>();
    public Converter (T[] arrayToConv) {
        this.arrayToConv = arrayToConv;
    }

    public void numericArrayToList(T[] arrayToConv) {
        for (int i = 0; i < arrayToConv.length; i++) {
            converteredList.add(arrayToConv[i]);
        }
    }

    public List<T> getList() {
        return this.converteredList;
    }

    public void printList( List <T> listToPrint ) {
        for (int i=0; i < listToPrint.size(); i++) {
            System.out.println(listToPrint.get(i));
        }
    }
}
