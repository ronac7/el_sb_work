package a.b.c.com.rboard.vo;

public class RboardVO {
	
	private String rsbnum;
	private String sbnum;
	private String rsbname;
	private String rsbcontent;
	private String rsbpw;
	private String rsbdelyn;
	private String rsbinsertdate;
	
	public RboardVO() {}

	public RboardVO(String rsbnum, String sbnum,
					String rsbname, String rsbcontent,
					String rsbpw, String rsbdelyn,
					String rsbinsertdate) {
		
		this.rsbnum = rsbnum;
		this.sbnum = sbnum;
		this.rsbname = rsbname;
		this.rsbcontent = rsbcontent;
		this.rsbpw = rsbpw;
		this.rsbdelyn = rsbdelyn;
		this.rsbinsertdate = rsbinsertdate;
	}

	public String getRsbnum() {
		return rsbnum;
	}

	public String getSbnum() {
		return sbnum;
	}

	public String getRsbname() {
		return rsbname;
	}

	public String getRsbcontent() {
		return rsbcontent;
	}

	public String getRsbpw() {
		return rsbpw;
	}

	public String getRsbdelyn() {
		return rsbdelyn;
	}

	public String getRsbinsertdate() {
		return rsbinsertdate;
	}

	public void setRsbnum(String rsbnum) {
		this.rsbnum = rsbnum;
	}

	public void setSbnum(String sbnum) {
		this.sbnum = sbnum;
	}

	public void setRsbname(String rsbname) {
		this.rsbname = rsbname;
	}

	public void setRsbcontent(String rsbcontent) {
		this.rsbcontent = rsbcontent;
	}

	public void setRsbpw(String rsbpw) {
		this.rsbpw = rsbpw;
	}

	public void setRsbdelyn(String rsbdelyn) {
		this.rsbdelyn = rsbdelyn;
	}

	public void setRsbinsertdate(String rsbinsertdate) {
		this.rsbinsertdate = rsbinsertdate;
	}
	
}
