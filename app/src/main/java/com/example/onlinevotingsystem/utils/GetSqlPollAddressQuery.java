package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlPollAddressQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+ TableKeys.TABLE_NAME_POLL_ADDRESS+
                "(`"+TableKeys.KEY_POLL_ADDRESS_NUMBER+"` int NOT NULL," +
                "`"+TableKeys.KEY_POLL_ADDRESS_ADDRESS+"`  varchar(50) NOT NULL," +
                "PRIMARY KEY (`"+TableKeys.KEY_POLL_ADDRESS_NUMBER+"`))";
    }

    public static String GetCheckPollNoExistsQuery(int pollno){
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_POLL_ADDRESS + " WHERE " + TableKeys.KEY_POLL_ADDRESS_NUMBER + " = " + pollno +  " )";
    }

    public static String GetPollDetailsQuery(int pollno) {
        return " SELECT *  FROM " + TableKeys.TABLE_NAME_POLL_ADDRESS + " WHERE " + TableKeys.KEY_POLL_ADDRESS_NUMBER + " = " + pollno + " )";
    }
}
