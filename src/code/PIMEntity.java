package code;

import java.io.Serializable;

public abstract class PIMEntity implements Serializable {
    public String owner;
//    public String ic;
    public boolean OwnerIsPublic;
	String Priority; // every kind of item has a priority

    // default constructor sets priority to "normal"
    PIMEntity() {
        Priority = "normal";
    }

    PIMEntity(String owner){
        this.owner = owner;
    }

    // priority can be established via this constructor.
    PIMEntity(boolean b) {
        OwnerIsPublic = b;
    }

    PIMEntity(String owner,boolean b){
        this.owner = owner;
        OwnerIsPublic = b;
    }



    // accessor method for getting the priority string
    public String getPriority() {
        return Priority;
    }
    // method that changes the priority string
    public void setPriority(String p) {
        Priority = p;
    }

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    // abstract public void fromString(String s);

    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    abstract public String toString();

    public void setOwnerIsPublic(boolean b) {
        OwnerIsPublic = b;
    }

}
