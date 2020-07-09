package code;

public class PIMNote extends PIMEntity {
	public static String kind = "NOTE";
	public String Priority; // each note has a priority
	public String content; // each note has a content
	
	PIMNote() {
        Priority = "normal";
    }
	
	PIMNote(String priority){
		this.Priority = priority;
	}
	
	@Override
	public String getPriority() {
		// TODO Auto-generated method stub
		return Priority;
	}
	
	@Override
	public void setPriority(String p) {
		// TODO Auto-generated method stub
		this.Priority = p;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
//	@Override
//	public void fromString(String s) {
//		return ;
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Public:" + OwnerIsPublic + " Kind:" + this.kind + " Priority:" + this.Priority
				+ " Content:" + this.content + "]";
	}

}
