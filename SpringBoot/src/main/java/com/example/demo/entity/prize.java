package com.example.demo.entity;

public class prize {
    private Integer prizeId;

    private Integer prizeListId;
    private String prizeName;
    private String prizeCount;
    private String prizePicDir;

    public String getPrizePicDir() {
        return prizePicDir;
    }

    public void setPrizePicDir(String prizePicDir) {
        this.prizePicDir = prizePicDir;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getPrizeListId() {
        return prizeListId;
    }

    public void setPrizeListId(Integer prizeListId) {
        this.prizeListId = prizeListId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(String prizeCount) {
        this.prizeCount = prizeCount;
    }
}
