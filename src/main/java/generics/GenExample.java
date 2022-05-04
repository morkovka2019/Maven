package generics;



public class GenExample {

    public static void main(String[] args) {
        Float[] myArr = new Float[]{22.3f, -44.8645645f, 0f, 1.8732e3f, 1.234f};
        Converter <Float> converter = new Converter<>(myArr);
        converter.numericArrayToList(myArr);
        converter.printList(converter.getList());
    }
}
