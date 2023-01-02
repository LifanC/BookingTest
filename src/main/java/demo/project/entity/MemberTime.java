package demo.project.entity;

public class MemberTime {
	private String timename;
	private String name;
	public MemberTime() {}
	public MemberTime(String timename) {
		this.timename = timename;
	}
	
	public String getTimename() {
		return timename;
	}
	public void setTimename(String timename) {
		this.timename = timename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
