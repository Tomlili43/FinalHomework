/*
 * Copyright (c) 2020.
 * projectName:FinalHomework
 * fileName:PIMAccount.java
 * Date:2020/7/1 上午8:46
 * Author: Zan Zhao
 */

package Account;

public class Account {
    private String userName;
    private String password;

    public Account() {}
    public Account(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}