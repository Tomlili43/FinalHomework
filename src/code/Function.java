/*
 * Copyright (c) 2020.
 * projectName:FinalHomework
 * fileName:Function.java
 * Date:2020/7/7 下午4:16
 * Author: Zan Zhao
 */

package code;

import java.util.Date;

public class Function implements RemotePIMCollection{

    @Override
    public PIMCollection getNotes() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getNotes(String owner) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getTodos() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getTodos(String owner) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAppointments() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAppointments(String owner) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getContacts() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getContacts(String owner) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getItemsForDate(Date d) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getItemsForDate(Date d, String owner) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAll() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAllByOwner(String owner) throws CustomizedException {
        return null;
    }

    @Override
    public boolean add(PIMEntity pimEntity) throws CustomizedException {
        return false;
    }
}
