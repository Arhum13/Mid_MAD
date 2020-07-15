public class working{
    String task;
    String detail;
    String Date;

    public working(String task, String detail, String date) {
        this.task = task;
        this.detail = detail;
        Date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}