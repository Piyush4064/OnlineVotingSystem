package com.example.onlinevotingsystem.utils;

import com.example.onlinevotingsystem.constants.TableKeys;

public class GetSqlInsertQuery {

    public static String GetExistingVotersInsertQuery(String name, String voterId, String PhoneNum, String dob, int PollNum){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_EXISTING_VOTERS +
                "` VALUES ('" + name + "','" + voterId + "','" + PhoneNum + "','" + dob + "'," + PollNum + "," + 0 + ")";
    }

    public static String GetRegisteredUserInsertQuery(String username, String voterId, String password,  String regtime , String photourl, int hasvoted){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_REGISTERED_USERS +
                "` VALUES ('" + username + "','" + voterId + "','" + password + "','" + regtime + "'," + photourl + "," + hasvoted + ")";
    }

    public static String GetAdminInsertQuery(String username, String password, String name, String photourl){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_ADMIN +
                "` VALUES ('" + username + "','"  + password + "','" + name + "','" + photourl + "','" + photourl +")";
    }

    public static String GetOfficerInsertQuery(String username, String password, String name, String photourl, int Pollnum){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_OFFICER +
                "` VALUES ('" + username + "','"  + password + "','" + name + "','" + photourl + "','" + photourl +"','" + Pollnum +")";
    }

    public static String GetCandidateInsertQuery(String name, String candid, String phoneno, String dob , String photourl ,  String elecsymbolname ,  String elecsymbolphoto , int Pollnum ,int novote){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_CANDIDATE +
                "` VALUES ('" + name + "','"  + candid + "','" + phoneno + "','" + dob + "','" + photourl + "','" + elecsymbolname  + "','" + elecsymbolphoto + "','" + Pollnum + "','" + novote + ")";
    }

    public static String GetPollInsertQuery(int Pollnum, String address, String offusername, int nocand , int novoters ,  String elecendtime ,  String elecstarttime ,  int novotecasted){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_POLL +
                "` VALUES ('" + Pollnum + "','"  + address + "','" + offusername + "','" + nocand + "','" + novoters + "','" + elecendtime  + "','" + elecstarttime + "','" + novotecasted  + ")";
    }



}
