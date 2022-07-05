package ge.tsu;

import java.time.LocalDate;

public class PaperCertificate extends Certificate {
    public PaperCertificate(String text, LocalDate issueDate, LocalDate expireDate) {
        super(text, issueDate, expireDate);
    }
}
