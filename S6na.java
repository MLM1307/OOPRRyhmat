public class S6na {
    private String sõnaVõõrkeeles;
    private String emakeelneVaste;

    public S6na(String sõnaVõõrkeeles, String emakeelneVaste) {
        this.sõnaVõõrkeeles = sõnaVõõrkeeles;
        this.emakeelneVaste = emakeelneVaste;
    }

    public String getSõnaVõõrkeeles() {
        return sõnaVõõrkeeles;
    }

    public void setSõnaVõõrkeeles(String sõnaVõõrkeeles) {
        this.sõnaVõõrkeeles = sõnaVõõrkeeles;
    }

    public void setEmakeelneVaste(String emakeelneVaste) {
        this.emakeelneVaste = emakeelneVaste;
    }

    public String getEmakeelneVaste() {
        return emakeelneVaste;
    }
    public String toString() {
        return sõnaVõõrkeeles + " - "+ emakeelneVaste;
    }
}
