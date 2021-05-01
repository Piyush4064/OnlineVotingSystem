package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlCreateTableString {

    public static String getExistingVotersCreateQuery(){
        return "CREATE TABLE IF NOT EXISTS "+TableKeys.TABLE_NAME_EXISTING_VOTERS+
        "(`"+TableKeys.KEY_EXISTING_VOTERS_NAME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_ID+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_PHONE_NUM+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_DOB+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_POLL_NUM+"` int NOT NULL," +
        "`"+TableKeys.KEY_EXISTING_VOTERS_IS_MOBILE_REGISTERED+"` tinyint NOT NULL," +
        "PRIMARY KEY (`"+TableKeys.KEY_EXISTING_VOTERS_ID+"`))";
    }

    public static String getRegisteredUserCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+TableKeys.TABLE_NAME_REGISTERED_USERS+
        "(`"+TableKeys.KEY_REGISTERED_USER_USERNAME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_REGISTERED_USER_VOTER_ID+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_REGISTERED_USER_PASSWORD+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_REGISTERED_USER_REG_TIME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_REGISTERED_USER_PHOTO_URL+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_REGISTERED_USER_HAS_VOTED+"` tinyint NOT NULL," +        
        "PRIMARY KEY (`"+TableKeys.KEY_REGISTERED_USER_VOTER_ID+"`))";
    }

    public static String getAdminCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+TableKeys.TABLE_NAME_ADMIN+
        "(`"+TableKeys.KEY_ADMIN_USERNAME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_ADMIN_NAME+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_ADMIN_PASSWORD+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_ADMIN_PHOTO_URL+"` varchar(50) NOT NULL," +
        "PRIMARY KEY (`"+TableKeys.KEY_ADMIN_USERNAME+"`))";
    }

    public static String getOfficerCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+TableKeys.TABLE_NAME_OFFICER+
        "(`"+TableKeys.KEY_OFFICER_USERNAME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_OFFICER_PASSWORD+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_OFFICER_POLL_NO+"`  int NOT NULL," +
        "`"+TableKeys.KEY_OFFICER_PHOTO_URL+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_OFFICER_NAME+"` varchar(50) NOT NULL," +
        "PRIMARY KEY (`"+TableKeys.KEY_OFFICER_USERNAME+"`))";
    }

    public static String getCandidateCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+TableKeys.TABLE_NAME_CANDIDATE+
        "(`"+TableKeys.KEY_CANDIDATE_NAME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_CAND_ID+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_PHONE_NO+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_DOB+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_PHOTO_URL+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_POLL_NO+"` tinyint NOT NULL," +       
        "`"+TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_NAME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_PHOTO+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_CANDIDATE_NO_VOTES+"` tinyint NOT NULL," +         
        "PRIMARY KEY (`"+TableKeys.KEY_CANDIDATE_CAND_ID+"`))";
    }

    public static String getPollCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+TableKeys.TABLE_NAME_POLL+
        "(`"+TableKeys.KEY_POLL_NUMBER+"` int NOT NULL," +
        "`"+TableKeys.KEY_POLL_ADDRESS+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_POLL_OFFICER_USERNAME+"`  varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_POLL_NO_CANDIDATES+"` int NOT NULL," +
        "`"+TableKeys.KEY_POLL_NO_VOTERS+"` int NOT NULL," +
        "`"+TableKeys.KEY_POLL_ELEC_START_TIME+"` varchar(50) NOT NULL," +       
        "`"+TableKeys.KEY_POLL_ELEC_END_TIME+"` varchar(50) NOT NULL," +
        "`"+TableKeys.KEY_POLL_NO_VOTES_CASTED+"` int DEFAULT 0," +
        "PRIMARY KEY (`"+TableKeys.KEY_POLL_NUMBER+"`))";
    }
}
