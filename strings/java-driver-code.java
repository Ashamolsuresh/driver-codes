

import java.util.*;
  
class GFG {
      
   
    static int recycledPairs(int[] a)
    {
        int count = 0;
          
   
        Arrays.sort(a);
        int n = a.length;
          
 
        int[] temp = new int[n];
        Arrays.fill(temp, -1);
        int j = 0;
          
        for (int i = 0; i < n - 1; i++)
            if (a[i] != a[i + 1])
                temp[j++] = a[i];
        temp[j++] = a[n - 1];
        int size = n;
        
        for (int i = n - 1; i >= 0; i--)
            if (temp[i] != -1) {
                size = i;
                break;
            }
          
   
        HashSet<Integer> hs = new HashSet<Integer>();
          
        for (int i = 0; i < size + 1; i++) {
              
           
            hs.clear();
            int x = temp[i];
              
         
            int d1 = (int)Math.log10(temp[i]) + 1;
  
            int f = (int)Math.pow(10, d1 - 1);
            for (j = 1; j <= d1 - 1; j++) {
                  
                
                int r = x % 10;
                  
            
                int q = x / 10;
                  
                
                x = r * f + q;
                  
           
                int d2 = (int)Math.log10(x) + 1;
                  
               
                if (!hs.contains(x)) {
                    hs.add(x);
                      
                  
                    if ((d1 == d2))
                    {
                      
                        int position = Arrays.binarySearch(temp, i + 1, size + 1, x);
                          
                    
                        if(position >= 0)
                        {
                            
                            count++;
                        }
                    }
                }
            }
        }
          
        
        return count;
    }
 
    public static void main(String[] args)
    {
        int a[] = { 1234,3412 };
        int result = recycledPairs(a);
        System.out.println("Recycled pair");
    }
}
