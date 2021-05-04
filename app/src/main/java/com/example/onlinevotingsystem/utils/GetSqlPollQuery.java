package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlPollQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+ TableKeys.TABLE_NAME_POLL+
                "(`"+TableKeys.KEY_POLL_NUMBER+"` int NOT NULL," +
                "`"+TableKeys.KEY_POLL_ADDRESS+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_POLL_OFFICER_USERNAME+"`  varchar(50) DEFAULT NULL," +
                "`"+TableKeys.KEY_POLL_NO_CANDIDATES+"` int DEFAULT 0," +
                "`"+TableKeys.KEY_POLL_NO_VOTERS+"` int DEFAULT 0," +
                "`"+TableKeys.KEY_POLL_ELEC_START_TIME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_POLL_ELEC_END_TIME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_POLL_NO_VOTES_CASTED+"` int DEFAULT 0," +
                "PRIMARY KEY (`"+TableKeys.KEY_POLL_NUMBER+"`))";
    }

    public static String GetInsertQuery(int Pollnum, String address, String elecendtime ,  String elecstarttime){
        return "INSERT INTO `" + TableKeys.TABLE_NAME_POLL +
                "`  ( " + TableKeys.KEY_POLL_NUMBER +"," + TableKeys.KEY_POLL_ADDRESS + "," + TableKeys.KEY_POLL_ELEC_START_TIME +"," + TableKeys.KEY_POLL_ELEC_END_TIME +" ) VALUES ('" + Pollnum + "','"  + address + "','"  + elecendtime  + "','" + elecstarttime + ")";
    }

    public static String GetCheckPollNoExistsQuery(int pollno){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_POLL + " WHERE " + TableKeys.KEY_POLL_NUMBER + " = " + pollno +  " )";
    }

}
