package poltekpos.ac.id.e_kuisoner.model;

import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("kd_pertanyaan")
    private String kd_pertanyaan;

    @SerializedName("pertanyaan")
    private String pertanyaan;

    public String getKd_pertanyaan() {
        return kd_pertanyaan;
    }

    public void setKd_pertanyaan(String kd_pertanyaan) {
        this.kd_pertanyaan = kd_pertanyaan;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }
}
