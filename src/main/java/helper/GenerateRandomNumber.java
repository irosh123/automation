package helper;

import java.util.Random;

public class GenerateRandomNumber {

    public Integer randomNumberGenerate(Integer emailRandomNumber)
    {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000000);


        // Print random integers
        System.out.println("Random Integers: "+rand_int1);
        return rand_int1;
    }
}
