
public class Questions {
	
	private int id;
	private String question_text;
	private String subject;
	private int max_marks;
	
	

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Questions(int id, String question_text, String subject, int max_marks) {
		super();
		this.id = id;
		this.question_text = question_text;
		this.subject = subject;
		this.max_marks = max_marks;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMax_marks() {
		return max_marks;
	}

	public void setMax_marks(int max_marks) {
		this.max_marks = max_marks;
	}
	
	
	
	
	
	
	

}
