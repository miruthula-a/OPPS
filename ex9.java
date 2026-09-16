
public class GenericMax { 

    public static <T extends Comparable<T>> T findMax(T[] array) { 

        T max = array[0]; 

        for (int i = 1; i < array.length; i++) { 

            if (array[i].compareTo(max) > 0) { 

                max = array[i]; 

            } 

        } 

        return max; 

    } 

    public static void main(String[] args) { 

        Integer[] intArray = {10, 25, 8, 40, 15}; 

        System.out.println("Maximum Integer = " + findMax(intArray)); 

        Double[] doubleArray = {12.5, 45.8, 33.2, 67.1, 29.4}; 

        System.out.println("Maximum Double = " + findMax(doubleArray)); 

        Character[] charArray = {'A', 'M', 'Z', 'D', 'K'}; 

        System.out.println("Maximum Character = " + findMax(charArray)); 

        String[] stringArray = {"Apple", "Mango", "Banana", "Zebra"}; 

        System.out.println("Maximum String = " + findMax(stringArray)); 

    } 

} 

 

 

 

 

 

 

