package com.example.onlinevotingsystem.queries;

import com.example.onlinevotingsystem.constants.TableKeys;

public class CandidateQuery {

    public static String getCreateQuery(){
        return "CREATE TABLE  IF NOT EXISTS "+ TableKeys.TABLE_NAME_CANDIDATE+
                "(`"+TableKeys.KEY_CANDIDATE_NAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_CAND_ID+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_PHONE_NO+"`  varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_DOB+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_PHOTO_URL+"` varchar(50) ," +
                "`"+TableKeys.KEY_CANDIDATE_POLL_NO+"` tinyint NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_NAME+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_PHOTO+"` varchar(50) NOT NULL," +
                "`"+TableKeys.KEY_CANDIDATE_NO_VOTES+"` tinyint NOT NULL," +
                "PRIMARY KEY (`"+TableKeys.KEY_CANDIDATE_CAND_ID+"`))";
    }

    public static String GetAddCandidateQuery(String name, String candid, String phoneno, String dob , String photourl ,  String elecsymbolname ,  String elecsymbolphoto , int Pollnum ,int novote){

        return "INSERT INTO `" + TableKeys.TABLE_NAME_CANDIDATE +
                "` VALUES ('" + name + "','"  + candid + "','" + phoneno + "','" + dob + "','" + photourl + "','" + elecsymbolname  + "','" + elecsymbolphoto + "','" + Pollnum + "','" + novote + ")";
    }


    public static String GetDeleteCandidateQuery(String candid){
        return " DELETE FROM " + TableKeys.TABLE_NAME_CANDIDATE + " WHERE " + TableKeys.KEY_CANDIDATE_CAND_ID + " = " + candid +  " )";
    }

    public static String GetPollWiseResultQuery(int pollno){
        return " SELECT * FROM " + TableKeys.TABLE_NAME_CANDIDATE + " WHERE " + TableKeys.KEY_CANDIDATE_POLL_NO + " = " + pollno + "ORDER BY " + TableKeys.KEY_CANDIDATE_NO_VOTES + " DESC LIMIT 3 )";
    }

    public static String GetPollWiseCandidateQuery(int pollno){
        return " SELECT * FROM " + TableKeys.TABLE_NAME_CANDIDATE + " WHERE " + TableKeys.KEY_CANDIDATE_POLL_NO + " = " + pollno;
    }

    public static String GetIncreaseCandidateVoteQuery(String candid) {
        return " UPDATE " + TableKeys.TABLE_NAME_CANDIDATE + " SET " + TableKeys.KEY_CANDIDATE_NO_VOTES  + " = " + TableKeys.KEY_CANDIDATE_NO_VOTES +  " + 1  WHERE "+ TableKeys.KEY_CANDIDATE_CAND_ID + " = " + candid + " )" ;
    }

    public static String GetAllCandidatesQuery(){
        return " SELECT * FROM " + TableKeys.TABLE_NAME_CANDIDATE ;
    }

}
