package Project.Records;

public class Feedback {
    private String feedbackID;
    private String feedback;
    private String date;
    private String time;

    public Feedback(String feedbackID, String feedback, String date, String time) {
        this.feedbackID = feedbackID;
        this.feedback = feedback;
        this.date = date;
        this.time = time;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
