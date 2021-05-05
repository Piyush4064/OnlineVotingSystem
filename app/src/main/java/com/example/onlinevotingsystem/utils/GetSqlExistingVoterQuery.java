package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlExistingVoterQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE IF NOT EXISTS "+TableKeys.TABLE_NAME_EXISTING_VOTERS+
                "(`"+TableKeys.KEY_EXISTING_VOTERS_NAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_EXISTING_VOTERS_ID+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_EXISTING_VOTERS_PHONE_NUM+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_EXISTING_VOTERS_DOB+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_EXISTING_VOTERS_POLL_NUM+"` int NOT NULL," +
                "`"+TableKeys.KEY_EXISTING_VOTERS_IS_MOBILE_REGISTERED+"` tinyint NOT NULL," +
                "PRIMARY KEY (`"+TableKeys.KEY_EXISTING_VOTERS_ID+"`))";
    }

    public static String GetInsertQuery(String name, String voterId, String PhoneNum, String dob, int PollNum){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_EXISTING_VOTERS +
                "` VALUES ('" + name + "','" + voterId + "','" + PhoneNum + "','" + dob + "'," + PollNum + "," + 0 + ")";
    }

    public static String GetCheckVoterIdQuery(String voterId){
        return " SELECT * FROM " + TableKeys.TABLE_NAME_EXISTING_VOTERS + " WHERE  "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = '" + voterId + "'";
    }

    public static String GetUpdateMobileRegisteredQuery(String voterId){
        return " UPDATE " + TableKeys.TABLE_NAME_EXISTING_VOTERS + " SET " + TableKeys.KEY_EXISTING_VOTERS_IS_MOBILE_REGISTERED  + "= 1 WHERE "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetVoterIdDataQuery(String voterId){
        return " SELECT * FROM" + TableKeys.TABLE_NAME_EXISTING_VOTERS + "WHERE  "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdatePhoneNoQuery(String voterId, String phoneNo){
        return " UPDATE " + TableKeys.TABLE_NAME_EXISTING_VOTERS + "SET " + TableKeys.KEY_EXISTING_VOTERS_PHONE_NUM  + " = " + phoneNo +  " WHERE "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdateDobQuery(String voterId, String dob){
        return " UPDATE " + TableKeys.TABLE_NAME_EXISTING_VOTERS + "SET " + TableKeys.KEY_EXISTING_VOTERS_DOB  + " = " + dob +  " WHERE "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdatePollNoQuery(String voterId, String pollNo){
        return " UPDATE " + TableKeys.TABLE_NAME_EXISTING_VOTERS + "SET " + TableKeys.KEY_EXISTING_VOTERS_POLL_NUM  + " = " + pollNo +  " WHERE "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetVoterListAccToPollNoQuery(int pollNo){
        return " SELECT * FROM" + TableKeys.TABLE_NAME_EXISTING_VOTERS + "WHERE  "+ TableKeys.KEY_EXISTING_VOTERS_POLL_NUM+ " = " + pollNo ;
    }
}
