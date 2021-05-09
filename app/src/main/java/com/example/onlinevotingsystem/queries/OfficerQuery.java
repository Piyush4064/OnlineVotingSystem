package com.example.onlinevotingsystem.queries;

import com.example.onlinevotingsystem.constants.TableKeys;

public class OfficerQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+ TableKeys.TABLE_NAME_OFFICER+
                "(`"+TableKeys.KEY_OFFICER_USERNAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_OFFICER_PASSWORD+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_OFFICER_PHOTO_URL+"` varchar(50) ," +
                "`"+TableKeys.KEY_OFFICER_NAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_OFFICER_PHONE_NO+"` varchar(50) NOT NULL," +
                "PRIMARY KEY (`"+TableKeys.KEY_OFFICER_USERNAME+"`))";
    }

    public static String GetInsertQuery(String username, String password, String name, String photourl, String phoneno){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_OFFICER +
                "` VALUES ('" + username + "','"  + password + "','" + name + "','" + photourl + "','" + phoneno +")";
    }

    public static String GetAuthenticateQuery(String username , String password){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_OFFICER + " WHERE " + TableKeys.KEY_OFFICER_USERNAME + " = '" + username + "' and " + TableKeys.KEY_OFFICER_PASSWORD + " = '" + password + "'";
    }

    public static String GetOfficerDataQuery(String username){
        return " SELECT * FROM " + TableKeys.TABLE_NAME_OFFICER + " WHERE " + TableKeys.KEY_OFFICER_USERNAME + " = '" + username + "'";
    }

    public static String GetCheckUserNameExistsQuery(String username){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_OFFICER + " WHERE " + TableKeys.KEY_OFFICER_USERNAME + " = " + username ;
    }

    public static String GetUserNameDataQuery(String username){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_OFFICER + " WHERE " + TableKeys.KEY_OFFICER_USERNAME + " = " + username;
    }

    public static String GetDeleteOfficeQuery(String username){
        return " DELETE FROM " + TableKeys.TABLE_NAME_OFFICER + " WHERE " + TableKeys.KEY_OFFICER_USERNAME + " = " + username ;
    }

    public static String GetUpdatePasswordQuery(String username , String password){
        return " UPDATE " + TableKeys.TABLE_NAME_OFFICER + " SET " + TableKeys.KEY_OFFICER_PASSWORD  + " = " + password +  " WHERE "+ TableKeys.KEY_OFFICER_USERNAME + " = " + username ;
    }

    public static String GetUpdatePhotoUrlQuery(String username , String photourl){
        return " UPDATE " + TableKeys.TABLE_NAME_OFFICER + " SET " + TableKeys.KEY_OFFICER_PHOTO_URL  + " = " + photourl +  " WHERE "+ TableKeys.KEY_OFFICER_USERNAME + " = " + username ;
    }

    public static String GetUpdatePhoneNoQuery(String username , String phoneno){
        return " UPDATE " + TableKeys.TABLE_NAME_OFFICER + " SET " + TableKeys.KEY_OFFICER_PHONE_NO  + " = " + phoneno +  " WHERE "+ TableKeys.KEY_OFFICER_USERNAME + " = " + username ;
    }

    public static String GetAllOfficerDataQuery(){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_OFFICER ;
    }
}
