/**
 * Created by Ananya on 3/11/2018.
 */
import java.util.*;
        import java.lang.*;


public class firstfit {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        System.out.println("Enter the no. of blocks");
        Scanner sc=new Scanner(System.in);
        int b=sc.nextInt();
        System.out.println("Enter the no. of processes");
        int p=sc.nextInt();
        Map<Integer,Integer> blockSizes=new HashMap<>();
        int i=0;
        System.out.println("Enter the sizes of blocks");
        for(;i<b;i++){
            int x=sc.nextInt();
            blockSizes.put(x,i+1);
        }
        System.out.println("Enter the sizes of processes");
        int[] processSize=new int[p];
        for(i=0;i<p;i++){
            processSize[i]=sc.nextInt();
        }

        for(i=0;i<p;i++){
            boolean allocated=false;
            for(int k:blockSizes.keySet()){

                if(k>=processSize[i])
                {
                    allocated=true;
                    System.out.println("Process No. : "+(i+1)+" Process :"+processSize[i]+" Block :"+blockSizes.get(k));
                    blockSizes.remove(k);
                    break;
                }
            }
            if(allocated==false){
                System.out.println("Process No. : "+(i+1)+" Process :"+processSize[i]+" Block :Not allocated");
            }

        }

    }
}
