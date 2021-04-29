package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlString {

    public static String getExistingVotersCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+TableKeys.TABLE_NAME_EXISTING_VOTERS+
        "('"+TableKeys.KEY_EXISTING_VOTERS_NAME+"' varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_ID+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_PHONE_NUM+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_DOB+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_POLL_NUM+"` int NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_IS_MOBILE_REGISTERED+"` tinyint NOT NULL," +
        "PRIMARY KEY (`"+TableKeys.KEY_EXISTING_VOTERS_ID+"`))";
    }





}
