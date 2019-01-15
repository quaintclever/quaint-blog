package com.quaint.blogback.pojo;

public class Rank {
    private Integer rId;

    private Integer rankId;

    private String rankName;

    private Integer powerId;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }
}