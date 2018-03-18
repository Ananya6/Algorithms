/**
 * Created by Portal on 3/13/2018.
 */
public class worstfit {
    public static void main(String[] args) {
        int[] blockSizes=/*{150,350};*/{100,500,200,300,600};
        int[] processSizes=/*{300,25,125,50};*/{212,417,112,426};
        System.out.println("Worst Fit Algorithm");
        for(int i=0;i<processSizes.length;i++){
            //boolean allocated=false;
            int reqBlockw=-1;
            for(int j=0;j<blockSizes.length;j++){
                if(processSizes[i]<=blockSizes[j]){
                    if(reqBlockw==-1){
                        reqBlockw=j;
                    }else{
                        if(blockSizes[j]>blockSizes[reqBlockw]){
                            reqBlockw=j;
                        }
                    }

                }
            }
            if(reqBlockw==-1){
                System.out.println("Process No. : "+(i+1)+" Process : "+processSizes[i]+" Block : Not Allocated");
            }
            else {
                blockSizes[reqBlockw]-=processSizes[i];
                System.out.println("Process No. : "+(i+1)+" Process : "+processSizes[i]+" Block :" +(reqBlockw+1));
            }
        }

    }
}
