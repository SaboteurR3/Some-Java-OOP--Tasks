package ge.tsu;

import java.time.LocalDate;

public abstract class Certificate {
    String text;
    LocalDate issueDate;
    LocalDate expireDate;

    public Certificate(String text, LocalDate issueDate, LocalDate expireDate) {
        this.text = text;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }
    public LocalDate getExpireDate() {
        return expireDate;
    }
    @Override
    public String toString() {
        return "Certificate{" +
                "text: " + text + '\'' +
                ", issueDate: " + issueDate +
                ", expireDate: " + expireDate +
                '}';
    }
}