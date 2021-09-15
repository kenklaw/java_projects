package p2_package;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class File_Input_Class
{
   
   private final String EMPTY_STRING = "";
   private final int HIGHEST_USABLE_CHAR_INT = 126; // tilde
   private final int LOWEST_USABLE_CHAR_INT = 32;  // space
   private final char MINUS_SIGN = '-';
   private final char PLUS_SIGN = '+';
   private final char RADIX_POINT = '.';
   private final char ZERO_CHAR = '0';
   private final char ZERO_VALUE = 0;
   private final int EOF_MARKER = -1;
   private FileReader inFile;
   private boolean openFileFlag;
   private boolean endOfFileFlag;

   /*
    * boolean returns if EOF
    */
   public boolean checkForEndOfFile()
   {
      return endOfFileFlag;
   }

   /*
    * Closes input file after reading
    */
   public boolean closeInputFile()
   {
      try
      {
         inFile.close();
      }

      catch( IOException ioe )
      {
         return false;
      }

      return true;
   }

   /*
    name: getChar
    process: ignores leading unprintable characters,
             captures first printable character
    */
   public char getChar()
   {
      int inCharInt = EOF_MARKER;

      if( openFileFlag )
      {
         try
         {
            inCharInt = inFile.read();

            // clear unprintable characters and spaces up to first character
            while( inCharInt != EOF_MARKER 
                  && ( inCharInt <= LOWEST_USABLE_CHAR_INT
                  || inCharInt > HIGHEST_USABLE_CHAR_INT ) )
            {
               inCharInt = inFile.read();
            }

            endOfFileFlag = inCharInt == EOF_MARKER;
         }

         catch( IOException ioe )
         {
            System.out.println("Error file not found");
         }

         if( !endOfFileFlag )
         {
            return (char)inCharInt;
         }
      }

      return ZERO_CHAR;
   }

   /*
    name: getDouble
    process: ignores leading unprintable characters,
             captures first contiguous double value,
             consumes first character after value
    */
   public double getDouble()
   {
      int inCharInt = EOF_MARKER;
      String strBuffer = EMPTY_STRING;
      double doubleValue = ZERO_VALUE;
      boolean negativeFlag = false;
      boolean digitFound = false;
      boolean firstRadixPointFound = false;
      boolean secondRadixPointFound = false;

      if( openFileFlag )
      {
         try
         {
            inCharInt = inFile.read();

            // clear unprintable characters and spaces up to first character
            while( inCharInt != EOF_MARKER 
                  && ( inCharInt <= LOWEST_USABLE_CHAR_INT
                  || inCharInt > HIGHEST_USABLE_CHAR_INT ) )
            {
               inCharInt = inFile.read();
            }

            endOfFileFlag = inCharInt == EOF_MARKER;

            if( !endOfFileFlag && (char)inCharInt == MINUS_SIGN )
            {
               negativeFlag = true;

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }

            else if( !endOfFileFlag && (char)inCharInt == PLUS_SIGN )
            {
               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }

            while( !endOfFileFlag 
                  && isCharInString( (char)inCharInt, "0123456789." ) 
                  && !secondRadixPointFound )
            {
               // only allows one radix point
               if( (char)inCharInt == RADIX_POINT )
               {                    
                  firstRadixPointFound = true;
               }

               strBuffer += (char)( inCharInt );

               if( (char)inCharInt >= '0' && (char)inCharInt <= '9' )
               {
                  digitFound = true;
               }

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;

               if( firstRadixPointFound && (char)inCharInt == RADIX_POINT )
               {
                  secondRadixPointFound = true;
               }
            }            
         }

         catch( IOException ioe )
         {
            System.out.println("Error file not found");
         }

         if( digitFound )
         {
            doubleValue = Double.parseDouble( strBuffer );

            if( negativeFlag )
            {
               doubleValue *= -1;
            }

            return doubleValue;                
         }       
      }

      return ZERO_VALUE;
   }

   /*
    name: getInt
    process: ignores leading unprintable characters,
             captures first contiguous integer,
             consumes first character after integer
    method input/parameters: none
    method output/parameters: none
    method output/returned: integer found if successful, ZERO_VALUE otherwise
    device input/file: character(s) captured from file as needed
    device output/monitor: none
    dependencies: FileReader tools, IOException
    */
   public int getInt()
   {
      int inCharInt = EOF_MARKER;
      String strBuffer = EMPTY_STRING;
      int intValue = ZERO_VALUE;
      boolean negativeFlag = false;
      boolean digitFound = false;

      if( openFileFlag )
      {
         try
         {
            inCharInt = inFile.read();

            // clear unprintable characters and spaces up to first character
            while( inCharInt != EOF_MARKER 
                  && ( inCharInt <= LOWEST_USABLE_CHAR_INT
                  || inCharInt > HIGHEST_USABLE_CHAR_INT ) )
            {
               inCharInt = inFile.read();
            }

            endOfFileFlag = inCharInt == EOF_MARKER;

            if( !endOfFileFlag && (char)inCharInt == MINUS_SIGN )
            {
               negativeFlag = true;

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }

            else if( !endOfFileFlag && (char)inCharInt == PLUS_SIGN )
            {
               inCharInt = inFile.read();
            }

            while( !endOfFileFlag 
                  && isCharInString( (char)inCharInt, "0123456789" ) )
            {   
               strBuffer += (char)( inCharInt );

               digitFound = true;

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }            
         }

         catch( IOException ioe )
         {
            System.out.println("Error file not found");
         }

         if( digitFound )
         {
            intValue = Integer.parseInt( strBuffer );

            if( negativeFlag )
            {
               intValue *= -1;
            }
         }

      }

      return intValue;
   }

   /*
    name: getLong
    process: ignores leading unprintable characters,
             captures first contiguous long int,
             consumes first character after long integer
    method input/parameters: none
    method output/parameters: none
    method output/returned: long integer found if successful, ZERO_VALUE otherwise
    device input/file: character(s) captured from file as needed
    device output/monitor: none
    dependencies: FileReader tools, IOException
    */
   public long getLong()
   {
      int inCharInt = EOF_MARKER;
      String strBuffer = EMPTY_STRING;
      long longValue = ZERO_VALUE;
      boolean negativeFlag = false;
      boolean digitFound = false;

      if( openFileFlag )
      {
         try
         {
            inCharInt = inFile.read();

            // clear unprintable characters and spaces up to first character
            while( inCharInt != EOF_MARKER 
                  && ( inCharInt <= LOWEST_USABLE_CHAR_INT
                  || inCharInt > HIGHEST_USABLE_CHAR_INT ) )
            {
               inCharInt = inFile.read();
            }

            endOfFileFlag = inCharInt == EOF_MARKER;

            if( !endOfFileFlag && (char)inCharInt == MINUS_SIGN )
            {
               negativeFlag = true;

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }

            else if( !endOfFileFlag && (char)inCharInt == PLUS_SIGN )
            {
               inCharInt = inFile.read();
            }

            while( !endOfFileFlag 
                  && isCharInString( (char)inCharInt, "0123456789" ) )
            {   
               strBuffer += (char)( inCharInt );

               digitFound = true;

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }            
         }

         catch( IOException ioe )
         {
            System.out.println("Error file not found");
         }

         if( digitFound )
         {
            longValue = Long.parseLong( strBuffer );

            if( negativeFlag )
            {
               longValue *= -1;
            }
         }

      }

      return longValue;
   }

   /*
    name: getRawChar
    process: captures first character including non-printable
    */
   public char getRawChar()
   {
      int inCharInt = EOF_MARKER;

      if( openFileFlag )
      {
         try
         {
            inCharInt = inFile.read();

            endOfFileFlag = inCharInt == EOF_MARKER;
         }

         catch( IOException ioe )
         {
            System.out.println("Error file not found");
         }

         return (char)inCharInt;
      }

      return ZERO_CHAR;
   }

   /*
    name: getString
    process: ignores leading unprintable characters,
             captures series of characters up to first space
    */
   public String getString()
   {
      return getString( (char)LOWEST_USABLE_CHAR_INT );
   }

   /*
    name: getString
    process: ignores leading unprintable characters,
             captures series of characters up to specified delimiters
    */
   public String getString( char delimiter )
   {
      int inCharInt = EOF_MARKER;
      String strBuffer = EMPTY_STRING;

      if( openFileFlag )
      {
         try
         {
            inCharInt = inFile.read();

            // clear unprintable characters and spaces up to first character
            while( inCharInt != EOF_MARKER 
                  && ( inCharInt <= LOWEST_USABLE_CHAR_INT
                  || inCharInt > HIGHEST_USABLE_CHAR_INT ) )
            {
               inCharInt = inFile.read();
            }

            endOfFileFlag = inCharInt == EOF_MARKER;

            while( !endOfFileFlag && inCharInt >= LOWEST_USABLE_CHAR_INT 
                  && inCharInt <= HIGHEST_USABLE_CHAR_INT 
                  && (char)inCharInt != (int)delimiter )
            {   
               strBuffer += (char)( inCharInt );

               inCharInt = inFile.read();

               endOfFileFlag = inCharInt == EOF_MARKER;
            }            
         }

         catch( IOException ioe )
         {
            System.out.println("Error file not found");
         }
      }

      return strBuffer;
   }

   /*
    name: isCharInString
    process: searches given string, reports if given character
             is located within the string
    */
   private boolean isCharInString( char testChar, String testString )
   {
      int index = 0;

      while( index < testString.length() )
      {
         if( testChar == testString.charAt( index ) )
         {
            return true;
         }

         index++;
      } 

      return false;
   }

   /*
    name: openInputFile
    process: opens input file, returns true if successful, false otherwise
    
    dependencies: FileReader tools, FileNotFoundException
    */
   public boolean openInputFile( String fileName )
   {
      try
      {
         inFile = new FileReader( fileName );
      }

      catch( FileNotFoundException fnfe )
      {
         return false;
      }

      openFileFlag = true;

      endOfFileFlag = false;

      return true;
   }

}