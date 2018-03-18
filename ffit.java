import java.util.ArrayList;

/**
 * Created by Portal on 3/13/2018.
 */
public class ffit {
    public static void main(String[] args) {
  int[] blockSizes=/*{150,350};*/{100,500,200,300,600};
        int[] processSizes=/*{300,25,125,50};*/{212,417,112,426};
        System.out.println("First Fit Algorithm");
        for(int i=0;i<processSizes.length;i++){
            boolean allocated=false;
            block: for(int j=0;j<blockSizes.length;j++){
                if(processSizes[i]<=blockSizes[j]){
                    allocated=true;
                    System.out.println("Process No. : "+(i+1)+" Process : "+processSizes[i]+" Block :" +(j+1));
                    blockSizes[j]-=processSizes[i];
                    break block;
                }
            }
            if(allocated==false){
                System.out.println("Process No. : "+(i+1)+" Process : "+processSizes[i]+" Block : Not Allocated");
            }
        }


    }
}
