package com.example.onlinevotingsystem.queries;

import com.example.onlinevotingsystem.constants.TableKeys;

public class VotersQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE IF NOT EXISTS "+ TableKeys.TABLE_NAME_VOTERS+
                "(`"+TableKeys.KEY_VOTERS_NAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_VOTERS_ID+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_VOTERS_PHONE_NUM+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_VOTERS_DOB+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_VOTERS_POLL_NUM+"` int NOT NULL," +
                "`"+TableKeys.KEY_VOTERS_IS_MOBILE_REGISTERED+"` tinyint NOT NULL," +
                "`"+TableKeys.KEY_VOTERS_PASSWORD+"` varchar(50) DEFAULT NULL," +
                "`"+TableKeys.KEY_VOTERS_REG_TIME+"` varchar(50) DEFAULT NULL," +
                "`"+TableKeys.KEY_VOTERS_PHOTO_URL+"` varchar(50) DEFAULT NULL," +
                "`"+TableKeys.KEY_VOTERS_HAS_VOTED+"` tinyint DEFAULT 0," +
                "PRIMARY KEY (`"+TableKeys.KEY_VOTERS_ID+"`))";
    }

    public static String GetInsertQuery(String name, String voterId, String PhoneNum, String dob, int PollNum){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_VOTERS +
                "` "+"("+ TableKeys.KEY_VOTERS_NAME +" "+ TableKeys.KEY_VOTERS_ID + " " + TableKeys.KEY_VOTERS_PHONE_NUM + " " +TableKeys.KEY_VOTERS_DOB
                +" " + TableKeys.KEY_VOTERS_POLL_NUM + " " + TableKeys.KEY_VOTERS_IS_MOBILE_REGISTERED  +")"
                +" VALUES ('" + name + "','" + voterId + "','" + PhoneNum + "','" + dob + "'," + PollNum + "," + 0 + ")";
    }

    public static String GetCheckVoterIdQuery(String voterId){
        return " SELECT * FROM " + TableKeys.TABLE_NAME_VOTERS + " WHERE  "+ TableKeys.KEY_VOTERS_ID + " = '" + voterId + "'";
    }

    public static String GetUpdateMobileRegisteredQuery(String voterId , String password , String regtime , String photourl){
        return " UPDATE " + TableKeys.TABLE_NAME_VOTERS + " SET " + TableKeys.KEY_VOTERS_IS_MOBILE_REGISTERED  + "= 1 "+","+ TableKeys.KEY_VOTERS_PASSWORD + "= " + password + "," +
                TableKeys.KEY_VOTERS_REG_TIME  + "= " + regtime + "," + TableKeys.KEY_VOTERS_PHOTO_URL + "= " + photourl + " WHERE "+ TableKeys.KEY_VOTERS_ID + " = " + voterId ;
    }

    public static String GetVoterIdDataQuery(String voterId){
        return " SELECT * FROM" + TableKeys.TABLE_NAME_VOTERS + "WHERE  "+ TableKeys.KEY_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdatePhoneNoQuery(String voterId, String phoneNo){
        return " UPDATE " + TableKeys.TABLE_NAME_VOTERS + "SET " + TableKeys.KEY_VOTERS_PHONE_NUM  + " = " + phoneNo +  " WHERE "+ TableKeys.KEY_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdateDobQuery(String voterId, String dob){
        return " UPDATE " + TableKeys.TABLE_NAME_VOTERS + "SET " + TableKeys.KEY_VOTERS_DOB  + " = " + dob +  " WHERE "+ TableKeys.KEY_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdatePollNoQuery(String voterId, String pollNo){
        return " UPDATE " + TableKeys.TABLE_NAME_VOTERS + "SET " + TableKeys.KEY_VOTERS_POLL_NUM  + " = " + pollNo +  " WHERE "+ TableKeys.KEY_VOTERS_ID + " = " + voterId ;
    }

    public static String GetVoterListAccToPollNoQuery(int pollNo){
        return " SELECT * FROM" + TableKeys.TABLE_NAME_VOTERS + "WHERE  "+ TableKeys.KEY_VOTERS_POLL_NUM+ " = " + pollNo ;
    }

    public static String GetAuthenticateQuery(String voterid , String password){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_VOTERS + " WHERE " + TableKeys.KEY_VOTERS_ID + " = '" + voterid + "' and " + TableKeys.KEY_VOTERS_PASSWORD + " = '" + password + "'";
    }

    public static String GetUpdatePasswordQuery(String voterid , String password){
        return " UPDATE " + TableKeys.TABLE_NAME_VOTERS + " SET " + TableKeys.KEY_VOTERS_PASSWORD  + " = " + password +  " WHERE "+ TableKeys.KEY_VOTERS_ID + " = '" + voterid ;
    }

    public static String GetUpdatePhotoUrlQuery(String voterid , String photoUrl){
        return " UPDATE " + TableKeys.TABLE_NAME_VOTERS + " SET " + TableKeys.KEY_VOTERS_PHOTO_URL  + " = " + photoUrl +  " WHERE "+ TableKeys.KEY_VOTERS_ID + " = '" + voterid ;
    }

    public static String GetUpdateHasVotedQuery(String voterid){
        return " UPDATE " + TableKeys.TABLE_NAME_ADMIN + " SET " + TableKeys.KEY_VOTERS_HAS_VOTED + " = " + 1 +  " WHERE "+ TableKeys.KEY_VOTERS_ID + " = '" + voterid ;
    }

}
