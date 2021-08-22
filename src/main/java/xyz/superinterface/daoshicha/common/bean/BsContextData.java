package xyz.superinterface.daoshicha.common.bean;

public class BsContextData {

    private String code;    //varchar(32) comment '导师code',
    private String type;    // 类型
    private String year;    // 年份
    private String end_text_n4_1;   //varchar(512) comment 'xx-xx年第一作者文章数据'

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEnd_text_n4_1() {
        return end_text_n4_1;
    }

    public void setEnd_text_n4_1(String end_text_n4_1) {
        this.end_text_n4_1 = end_text_n4_1;
    }
}
