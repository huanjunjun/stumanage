package javabean;
public class stu_score {
      private int sid;
      private String sname;
      private String smajor;
      private int mscore;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public int getMscore() {
		return mscore;
	}
	public void setMscore(int mscore) {
		this.mscore = mscore;
	}
	@Override
	public String toString() {
		return "stu_score [sid=" + sid + ", sname=" + sname + ", smajor=" + smajor + ", mscore=" + mscore + "]";
	}
}
