package com.caacet.wll.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AccountRecord {

    private Integer id;
    private String name;
    private Integer type;
    private String content;
    private String note;
    private BigDecimal amount;
    private Date time;

    public AccountRecord(){}

    public AccountRecord(Integer id, String name, Integer type, String content, String note, BigDecimal amount, Date time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.content = content;
        this.note = note;
        this.amount = amount;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AccountRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}
