package com.example.rajeevnagarwal.assignment3;

import android.provider.BaseColumns;

/**
 * Created by Rajeev Nagarwal on 10/1/2016.
 */
/* Class person to define database and tables inside it*/
public final class Person {
   private Person()
   {}
   public class PersonEntry implements BaseColumns{
       public static final String TABLE_NAME="Person";
       public static final String COLUMN_FIRSTNAME = "firstname";
       public static final String COLUMN_LASTNAME = "lastname";

   }


}
