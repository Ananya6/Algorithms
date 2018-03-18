/**
 * Created by Portal on 3/13/2018.
 */
public class bestfit {
    public static void main(String[] args) {
        int[] blockSizes=/*{150,350};*/{100,500,200,300,600};
        int[] processSizes=/*{300,25,125,50};*/{212,417,112,426};
        System.out.println("Best Fit Algorithm");
        //ArrayList<Integer> bestfit=new ArrayList<>();
        for(int i=0;i<processSizes.length;i++){
            //boolean allocated=false;
            int prevdiff=Integer.MAX_VALUE;
            int reqBlock=-1;
            for(int j=0;j<blockSizes.length;j++){
                if(processSizes[i]<=blockSizes[j]){

                    int currentDiff=blockSizes[j]-processSizes[i];
                    if(currentDiff<prevdiff){
                        prevdiff=currentDiff;
                        reqBlock=j;
                    }
                }
            }
            if(reqBlock==-1){
                System.out.println("Process No. : "+(i+1)+" Process : "+processSizes[i]+" Block : Not Allocated");
            }else{
                blockSizes[reqBlock]-=processSizes[i];
                System.out.println("Process No. : "+(i+1)+" Process : "+processSizes[i]+" Block :" +(reqBlock+1));
            }
        }
    }
}
