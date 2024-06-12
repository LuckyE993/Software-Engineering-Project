package com.example.demo.utils;

public interface Result {

    public static final int SUCCESS = 20000;
    public static final int ERROR = 20001;
    public static final int PASSWORD_ERROR = 20006;
    public static final int PASSWORD_CORRECT = 20007;
    public static final int USER_NONEXISTENT = 20008;
    public static final int USER_ALREADY_EXISTS = 20009;
    public static final int USER_REGISTER_SUCCESS = 20010;
    public static final int USER_REGISTER_FAIL = 20011;
    public static final int USER_LOGOUT_SUCCESS = 20012;//USER_LOGOUT_SUCCESS

    public static final int ADMIN_QUERY_USERS_SUCCESS = 20013;
    public static final int ADMIN_QUERY_USERS_FAIL = 20014;
    public static final int ADMIN_ADD_USER_SUCCESS = 20015;
    public static final int ADMIN_ADD_USER_FAIL = 20016;
    public static final int ADMIN_DELETE_USER_SUCCESS = 20017;
    public static final int ADMIN_DELETE_USER_FAIL = 20018;
    public static final int ADMIN_UPDATE_USER_SUCCESS = 20019;
    public static final int ADMIN_UPDATE_USER_FAIL = 20020;

}
