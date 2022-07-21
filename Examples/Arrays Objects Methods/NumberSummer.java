/* This example shows how to use a loop to accumulate a running total. */
public class NumberSummer{
    public static void main(String[] args){
    
        // Here we add up all the numbers from 1 to 10:
        int total = 0;
        for(int i = 1; i <= 10; i++)
        {
            total = total + i;
        }
        System.out.println(total);
        
        
        // Here we add up all the elements of an array:
        int[] someNumbers = new int[]{8,3,5,2,7,7,4};
        int arrayTotal = 0;
        for(int index = 0; index < someNumbers.length; index++)
        {
            arrayTotal = arrayTotal + someNumbers[index];
        }
        System.out.println(arrayTotal);
    }
}