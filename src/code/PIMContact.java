package code;

public class PIMContact extends PIMEntity {
	public static String kind = "CONTACT";
	public String Priority; // each contact has a priority
	public String firstName;
	public String familyName;
	public String emailAddress;
	
	PIMContact() {
        Priority = "normal";
    }
	
	public void set(String priority, String fir, String fam, String e){
		this.Priority = priority;
		this.firstName = fir;
		this.familyName = fam;
		this.emailAddress = e;
	}
	
	@Override
	public String getPriority() {
		// TODO Auto-generated method stub
		return super.getPriority();
	}
	
	@Override
	public void setPriority(String p) {
		// TODO Auto-generated method stub
		super.setPriority(p);
	}
	
//	@Override
//	public void fromString(String s) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + kind + " " + Priority
				+ " " + firstName + " " + familyName + " " + emailAddress + "]";
	}

}
