package leetcodepremium;

public class SortedArraySquares {
    
    public static int[] GetSortedArrayOfSquares(int[] a)
    {
        if (a == null || a.length == 0)
            return a;
        
        
        // Set I at the begining of positive numbers and J in the last negative number
        int i=0;
        while (a[i] < 0)
            i++;
        int j = i - 1;
        
        int index = 0;
        int[] result = new int[a.length];
        
        // Join both sorted lists
        while (j >=0 && i < a.length)
        {
            int n1 = a[i] * a[i];
            int n2 = a[j] * a[j];
            
            if (n1 <= n2)
            {
                result[index] = n1;
                i++;
            }
            else
            {
                result[index] = n2;
                j--;
            }
            
            index++;
        }
        
        // Copy the remainder 
        while (j >=0)
        {
            result[index] = a[j] * a[j];;
            j--;
            index++;
        }
        
        while (i < a.length)
        {
            result[index] = a[i] * a[i];
            i++;
            index++;
        }
        
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
