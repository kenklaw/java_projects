class sum_i_n
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int i;
        int j;
        int value = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        
        for(i = 0; i < n; i++){
            //reset value need to check from new i
            value = arr[i];
            
            for(j = i+1; j <= n; j++){
                if(value == s){
                    a.add(i+1);
                    a.add(j);
                    return (a);
                }
                if(value > s || j == n){
                    break;
                }
                
                value = value + arr[j];
    
            }
            
        }
        a.add(-1);
        return (a);
        }
        
    }