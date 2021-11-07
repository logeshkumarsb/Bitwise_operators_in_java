import java.util.Scanner;

public class bitoperator {
   public static void main(String[] args) {
   //to find whether it has set in given position
   System.out.println("Which program do you want to run");
   /*
     1 for to chech set
     2 for to extract set
   */  
   Scanner input=new Scanner(System.in);
   int opt=input.nextInt();
   switch(opt){
   case 1:
   {
   int n=5;
   int i=2;//given position.
   //to find set first we have to make a mask
   int mask=(1<<i);//we are using left shift operation to change 1 to given position
   /*example
   {3 bits//can be applicable for all bits}
   given n=5, binary of 5 is 101 and pos is 2  // 0 based position//
   so we will have to make a mask with 1 bit in the given position
   hence, bianry of 1 is  001 if we right shift it by given position
   it will become 001->100
   if we do and operation between given n and mask    1&1->1,1&0->0,0&1->0,0&0->0
         1 0 1
       & 1 0 0
       ---------
         1 0 0    which is not equal to zero so it has bit in the given position hence it is a set
       ---------     
    else if position was 1
         1 0 1
       & 0 1 0
       ---------
         0 0 0    which is  equal to zero so it has no bit in the given position hence it is a not a set
       --------- 
   */
   int ans=mask&n;
   if(ans!=0){
      System.out.println("Yes");
    }    
    else{
        System.out.println("No");
    }
   break;
   }
   case 2:
   {
   /*
   example:
     given n=5
     binary rep-> 101
     pos->2
     hence we will right shift by pos-1
     that is 101>>3-1 ==> 001 and then do AND op with 1
      0 0 1
    & 0 0 1
    -------
      0 0 1 == 1 means it has 1 at given poistion
    -------
    else it has zero int it 0
   */
   //to extract a bit at a given position
   int pos=2;
    int n=5;
    int ans=n>>pos-1;
    if((ans&1)==1){
        System.out.println(1);
    }  
    else {
        System.out.println(0);
    }
    break;
    }  
   // to set a bit set 1 at given position 
    case 3:
    {
        /*
        example:
        given n=9
        i have to set 1 at my desired position 1
        hence i will create a mask
        mask will be mask=1<<pos because to make set at guven positiin we need 1 at that position in mask
        and if we do or operation we will get 1 at the postion 
        if it already has 1 means then no problem just 1|1->1
        binary rep of 9->  1001
        mask-> 0001(1)<<pos=1-> 0010 
              1 0 0 1
            | 0 0 1 0
            -----------
              1 0 1 1  hence we set 1 at the given position 1
            -----------
            hence 9 will become 11
            1011->11
        */ 
      int pos=1;
      int n=9;
      int mask=1<<pos;
    //   System.out.println(Integer.toBinaryString(n));
      System.out.println((n|mask));

    }
    //to clear a set at given position 
    case 4:
    {
        /** 
         * to delete a set given position
         *  mask=(0001<<pos)-> ~(0010)->1101
         *  do and opeartion
         *     1 0 1 1
         *   & 1 1 0 1
         *    ---------
         *     1 0 0 1
         *    --------- 
         *    11 gives 9 (1011->1001)
         *    
        */
      int pos=1;
      int n=11;
      int mask=~(1<<pos);
      System.out.println(n&mask);  
    }
    //to delete the first occuring set
    case 5:
    {
        /**
         * example:
         *    //0 based index
         *    first to check the first occurence of 1
         *    given number 11 has  1011 in which 1  is at first position itself
         *    so we have to remove it 
         *    but if n is even number 
         *    eg: 12=>  1100 in which first occurence is at 2 pos
         *    how can we remove it just simple trick
         *    first find the number which is 1 less than the value that means just sub n-1
         *    then do and operation between n&n-1;
         *    for 11:
         *    11 -> 1011
         *    11-1=10-> 1010 
         *       1 0 1 1   
         *     & 1 0 1 0
         *      - - - - -
         *       1 0 1 0   -> first 1 got cleared 1011->1010
         *      - - - - -
         *    for 12: 
         *       12 -> 1100
         *       12-1=11->1011
         *         1 1 0 0
         *       & 1 0 1 1
         *       - - - - - -
         *         1 0 0 0  -> first 1 got cleared 1100->1000
         *       - - - - - -
         */
        int n=11;
        System.out.println(n&(n-1));
    }
    // to check no of 1 bits and 0 bits in a number 
    case 6:
    {
        int n=11;
        int count1=0;
        int count2=0;
        while(n!=0){
            if((n&1)==1){
                count1++;
            }
            else{
                count2++;
            }
            n=n>>1;
        }
        System.out.println(count1);
        System.out.println(count2);
    } 
    //to check that a given number is power of two or not
    case 7:
    {
        int n=12;
        if((n&(n-1))==0){
          System.out.println(n+" is power of two");
        }
        else{
            System.out.println(n+" is not a power of two");
        }
    }
  }     
 }
}
