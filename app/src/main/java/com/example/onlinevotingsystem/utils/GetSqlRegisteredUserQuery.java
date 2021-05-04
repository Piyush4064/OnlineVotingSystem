package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlRegisteredUserQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+ TableKeys.TABLE_NAME_REGISTERED_USERS+
                "(`"+TableKeys.KEY_REGISTERED_USER_USERNAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_REGISTERED_USER_VOTER_ID+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_REGISTERED_USER_PASSWORD+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_REGISTERED_USER_REG_TIME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_REGISTERED_USER_PHOTO_URL+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_REGISTERED_USER_HAS_VOTED+"` tinyint NOT NULL," +
                "PRIMARY KEY (`"+TableKeys.KEY_REGISTERED_USER_VOTER_ID+"`))";
    }

    public static String GetInsertQuery(String username, String voterId, String password,  String regtime , String photourl, int hasvoted){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_REGISTERED_USERS +
                "` VALUES ('" + username + "','" + voterId + "','" + password + "','" + regtime + "'," + photourl + "," + hasvoted + ")";
    }

    public static String GetAuthenticateQuery(String username , String password){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_REGISTERED_USERS + " WHERE " + TableKeys.KEY_REGISTERED_USER_USERNAME + " = " + username + " and " + TableKeys.KEY_REGISTERED_USER_PASSWORD + " = " + password + " )";
    }

    public static String GetCheckVoterIdExistsQuery(String voterId){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_REGISTERED_USERS + " WHERE " + TableKeys.KEY_REGISTERED_USER_VOTER_ID + " = " + voterId +  " )";
    }

    public static String GetCheckUsenNameExistsQuery(String username){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_REGISTERED_USERS + " WHERE " + TableKeys.KEY_REGISTERED_USER_USERNAME + " = " + username +  " )";
    }

}
