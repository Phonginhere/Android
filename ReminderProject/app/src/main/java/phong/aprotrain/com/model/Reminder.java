package phong.aprotrain.com.model;

import java.io.Serializable;

public class Reminder implements Serializable {
    private String noidung;
    private boolean quantrong;

    public Reminder(String noidung, boolean quantrong) {
        this.noidung = noidung;
        this.quantrong = quantrong;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public boolean isQuantrong() {
        return quantrong;
    }

    public void setQuantrong(boolean quantrong) {
        this.quantrong = quantrong;
    }
}
