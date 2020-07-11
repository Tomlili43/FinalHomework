package code;

import javax.swing.text.Keymap;
import java.util.Date;

public interface RemotePIMCollection {
    public PIMCollection getNotes() throws CustomizedException;
    public PIMCollection getNotes(String owner) throws CustomizedException;
    public PIMCollection getTodos() throws CustomizedException;
    public PIMCollection getTodos(String owner) throws CustomizedException;
    public PIMCollection getAppointments() throws CustomizedException;
    public PIMCollection getAppointments(String owner) throws CustomizedException;
    public PIMCollection getContacts() throws CustomizedException;
    public PIMCollection getContacts(String owner) throws CustomizedException;
    public PIMCollection getItemsForDate(Date d) throws CustomizedException;
    public PIMCollection getItemsForDate(Date d, String owner) throws CustomizedException;
    public PIMCollection getAll() throws CustomizedException;
    public PIMCollection getAllByOwner(String owner) throws CustomizedException;
    public boolean add(PIMEntity pimEntity) throws CustomizedException;
}
