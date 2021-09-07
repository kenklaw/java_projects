// Java code wars solutions


import java.util.*;

public class Kata {

  public static int findLongest(final String str) {
    String[] spl = str.split(" ");   
    int longest = 0;   
    for (int i=0; i < spl.length; i++) {
      if (spl[i].length() > longest) {
        longest = spl[i].length();
      }
      }
      return longest;
  }
  
}




public class Line {
    public static String Tickets(int[] peopleInLine)
    {
      int i;
      int twenty = 0;
      int fifty = 0;
      int hundred = 0;
   
      for(i = 0; i < peopleInLine.length; i++){
           
        // let person in & reg as enough money add +25
        if(peopleInLine[i] == 25){
          twenty++;        
        }
        
        // if 50 check if we have a 25 to give else no
        if(peopleInLine[i] == 50){
                  
          if(twenty >= 1){
            twenty--;
            fifty++;      
          }
          else{          
            return "NO";
          }       
        }
        
        //if 100 check for highest bill cash back first otherwise 20 if not no
        if(peopleInLine[i] == 100){
                  
          if(twenty >= 1 && fifty >= 1){
            twenty--;
            fifty--;
            hundred++;                    
          }          
          else if(twenty >= 3){
            twenty = twenty - 3;
            hundred++;          
          }
          else{
            return "NO";
          }       
        }
  
    }
      return "YES";
  }
    }




class Kata {
    public static String getMiddle(String word) {
        
        int len = word.length();
        
        int middle = len / 2;
        char mid_char = word.charAt(middle);
        String mid_str = Character.toString(mid_char);
        
        if(len % 2 == 0){
        int second_middle = middle - 1;
        char mid_two = word.charAt(second_middle);
        String second_str = Character.toString(mid_two);
        
        return second_str + mid_str;
        }
        return mid_str;
        
        
    
    }
    }



public class Kata {

    public static int[] between(int a, int b) {
        //get the length of the array to create
        
        int total_length = 0;
        int arr_index = 0;
        int i;
        int new_a = a;
        
        
        while( new_a < b){
        total_length++;
        new_a++;
        }
        
        System.out.println(total_length);
        
        //create the array of the correct size
        int[] arr = new int[total_length + 1];
        
        
        for(i = a; i <= b; i++){
        System.out.println(i);
        arr[arr_index] = i;
        arr_index++;
        }
        return(arr);
        
    }
    
    
}




public class JadenCase {

    public String toJadenCase(String phrase) {
      // TODO put your code below this comment
      
      // for empty string
      if(phrase == null || phrase.isEmpty()){
        return null;
      }
      
      StringBuffer sb = new StringBuffer(phrase);
      
          for(int i=0; i < sb.length(); i++){
            
              if(i==0 || sb.charAt(i-1)==' ')
                  sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
              
       return sb.toString();  
    }
  
  }
