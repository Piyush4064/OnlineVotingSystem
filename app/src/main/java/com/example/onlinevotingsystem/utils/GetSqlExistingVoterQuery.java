package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlExistingVoterQuery {

    public static String GetCheckVoterIdQuery(String voterId){
        return " SELECT * FROM" + TableKeys.TABLE_NAME_EXISTING_VOTERS + "WHERE  "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetUpdateMobileRegisteredQuery(String voterId){
        return " UPDATE " + TableKeys.TABLE_NAME_EXISTING_VOTERS + "SET " + TableKeys.KEY_EXISTING_VOTERS_IS_MOBILE_REGISTERED  + "= 1 WHERE "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }

    public static String GetVoterIdDataQuery(String voterId){
        return " SELECT * FROM" + TableKeys.TABLE_NAME_EXISTING_VOTERS + "WHERE  "+ TableKeys.KEY_EXISTING_VOTERS_ID + " = " + voterId ;
    }
}
