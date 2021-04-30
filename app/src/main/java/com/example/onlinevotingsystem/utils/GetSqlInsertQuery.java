package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlInsertQuery {

    public static String GetExistingVotersInsertQuery(String name, String voterId, String PhoneNum, long dob, int PollNum){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_EXISTING_VOTERS +
                "` VALUES ('" + name + "','" + voterId + "','" + PhoneNum + "','" + dob + "'," + PollNum + "," + 0 + ")";
    }



}
