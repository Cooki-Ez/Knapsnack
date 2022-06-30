package com.company;

public class Main {
    static int [] weights = {3, 1, 6, 10, 1, 4, 9, 1, 7, 2, 6, 1, 6, 2, 2, 4, 8, 1, 7, 3, 6, 2, 9, 5, 3, 3, 4, 7, 3, 5, 30, 50};
    static int [] values = {7, 4, 9, 18, 9, 15, 4, 2, 6, 13, 18, 12, 12, 16, 19, 19, 10, 16, 14, 3, 14, 4, 15, 7, 5, 10, 10, 13, 19, 9, 8, 5};
    static int size = 32;
    static int W_max = 75; //max weight
    public static void main(String[] args) {
	    Result result = new Result(0, 0);
        for(long i = 1; i < (long) Math.pow(2, size); i++)  //generate all vectors (size = 32) 0000 ... 0000 - 1111 ... 1111
        {
            long sumValues = 0;
            long sumWeights = 0;
            int index = 0;
            for(long j = (long) Math.pow(2, size-1); j > 0; j/=2)
            {
                if((i&j)>0) //and between all possible vectors if it is greater than 0 change sum of values and weights
                {
                    sumValues+=values[index];
                    sumWeights+=weights[index];
                }
                index++;
            }
            if(sumWeights<=W_max && sumValues>=result.Value)    //check if new value is greater and max weight not exceeded change result
            {
                result = new Result(i, sumValues);
            }
        }
        String name = Long.toBinaryString(result.Name); //convert long to binary
        StringBuilder finalString = new StringBuilder();
        if(name.length()<size) {    //paste 0's in front
            finalString.append("0".repeat((size - name.length())));
        }
        finalString.append(name);
        System.out.println(finalString);
    }
}
