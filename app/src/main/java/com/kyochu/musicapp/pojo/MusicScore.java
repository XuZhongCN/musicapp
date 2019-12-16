package com.kyochu.musicapp.pojo;

public class MusicScore {
    private Integer _id;
    private Integer music_id;
    private Integer order_num;
    private Integer score;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Integer music_id) {
        this.music_id = music_id;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MusicScore{" +
                "_id=" + _id +
                ", music_id=" + music_id +
                ", order_num=" + order_num +
                ", score=" + score +
                '}';
    }
}
