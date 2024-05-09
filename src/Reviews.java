
public class Reviews {
    private String[] comments;
    private int count;
    public Reviews() {
    }

    public Reviews(int capacity) {
        comments = new String[capacity];
        count = 0;
    }

    public void addComment(String comment) {
        if (count < comments.length) {
            comments[count] = comment;
            count++;
        } else {
            System.out.println("Не вдалося додати коментар.");
        }
    }
    public String [] getComments() {
        return comments;
    }
}
