package xyz.superinterface.daoshicha.common.bean;

public class BsContextNum {

    private String code;    //varchar(32) primary key comment '导师code',
    private String year;    //varchar(32) comment '年份',
    private Integer context_num; //int comment '文章数量',
    private Integer count_num;   //int comment '引用次数'

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getContext_num() {
        return context_num;
    }

    public void setContext_num(Integer context_num) {
        this.context_num = context_num;
    }

    public Integer getCount_num() {
        return count_num;
    }

    public void setCount_num(Integer count_num) {
        this.count_num = count_num;
    }
}
