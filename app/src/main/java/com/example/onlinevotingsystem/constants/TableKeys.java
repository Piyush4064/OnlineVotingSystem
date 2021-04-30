package com.example.onlinevotingsystem.constants;

public class TableKeys {

    public static final String TABLE_NAME_EXISTING_VOTERS="existing_voters";
    public static final String TABLE_NAME_REGISTERED_USERS="registered_users";
    public static final String TABLE_NAME_ADMIN="admin";
    public static final String TABLE_NAME_OFFICER="officer";
    public static final String TABLE_NAME_CANDIDATE="candidate";
    public static final String TABLE_NAME_POLL="poll";

    public static final String KEY_EXISTING_VOTERS_NAME="name";
    public static final String KEY_EXISTING_VOTERS_ID="voter_id";
    public static final String KEY_EXISTING_VOTERS_PHONE_NUM="phone_num";
    public static final String KEY_EXISTING_VOTERS_DOB="dob";
    public static final String KEY_EXISTING_VOTERS_POLL_NUM="poll_num";
    public static final String KEY_EXISTING_VOTERS_IS_MOBILE_REGISTERED="is_mob_reg";

    public static final String KEY_REGISTERED_USER_USERNAME="username";
    public static final String KEY_REGISTERED_USER_VOTER_ID="voter_id";
    public static final String KEY_REGISTERED_USER_PASSWORD="password";
    public static final String KEY_REGISTERED_USER_REG_TIME="reg_time";
    public static final String KEY_REGISTERED_USER_PHOTO_URL="photo_url";
    public static final String KEY_REGISTERED_USER_HAS_VOTED="has_voted";

    public static final String KEY_ADMIN_USERNAME="username";
    public static final String KEY_ADMIN_NAME="name";
    public static final String KEY_ADMIN_PASSWORD="password";
    public static final String KEY_ADMIN_PHOTO_URL="photo_url";

    public static final String KEY_OFFICER_USERNAME="username";
    public static final String KEY_OFFICER_PASSWORD="password";
    public static final String KEY_OFFICER_POLL_NO="poll_no";
    public static final String KEY_OFFICER_PHOTO_URL="photo_url";
    public static final String KEY_OFFICER_NAME="name";

    public static final String KEY_CANDIDATE_NAME="name";
    public static final String KEY_CANDIDATE_CAND_ID="cand_id";
    public static final String KEY_CANDIDATE_PHONE_NO="phone_no";
    public static final String KEY_CANDIDATE_DOB="dob";
    public static final String KEY_CANDIDATE_PHOTO_URL="photo_url";
    public static final String KEY_CANDIDATE_POLL_NO="poll_no";
    public static final String KEY_CANDIDATE_ELEC_SYMBOL_NAME="elec_symbl_name";
    public static final String KEY_CANDIDATE_ELEC_SYMBOL_PHOTO="elec_sybol_photo";
    public static final String KEY_CANDIDATE_NO_VOTES="no_votes";    


    public static final String KEY_POLL_NUMBER="number";
    public static final String KEY_POLL_ADDRESS="address";
    public static final String KEY_POLL_OFFICER_USERNAME="officer_username";
    public static final String KEY_POLL_NO_CANDIDATES="no_candidates";
    public static final String KEY_POLL_NO_VOTERS="no_voters";
    public static final String KEY_POLL_ELEC_START_TIME="elec_start_time";
    public static final String KEY_POLL_ELEC_END_TIME="elec_end_time";
    public static final String KEY_POLL_NO_VOTES_CASTED="no_votes_casted";


    public static final String GIT_CHECK="check";

}
