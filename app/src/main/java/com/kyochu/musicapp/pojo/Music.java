package com.kyochu.musicapp.pojo;

public class Music {
    private Integer _id;
    private String name;
    private Integer sectionSize;
    private String beat;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getSectionSize() {
        return sectionSize;
    }

    public void setSectionSize(Integer sectionSize) {
        this.sectionSize = sectionSize;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    @Override
    public String toString() {
        return "Music{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", sectionSize=" + sectionSize +
                ", beat='" + beat + '\'' +
                '}';
    }
}
