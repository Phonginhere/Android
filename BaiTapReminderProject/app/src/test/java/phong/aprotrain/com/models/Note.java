package phong.aprotrain.com.models;

import java.util.Date;


public class Note {
    private String noidung;
    private boolean quantrong;
    private Date ngaytao;

    public Note(String noidung, boolean quantrong, Date ngaytao) {
        this.noidung = noidung;
        this.quantrong = quantrong;
        this.ngaytao = ngaytao; //ISO8601 strings ("YYYY-MM-DD HH:MM:SS."
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

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }
}
