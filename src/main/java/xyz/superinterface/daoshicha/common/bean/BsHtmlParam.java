package xyz.superinterface.daoshicha.common.bean;

public class BsHtmlParam {
    private String  code;                     //  varchar(32) primary key comment '导师code',
    private String  name0;                    //  varchar(64) comment '教授名称',
    private String  name1;                    //  varchar(64) comment '导师',
    private String  email;                    //  varchar(64) comment '邮箱',
    private String  phone;                    //  varchar(64) comment '电话',
    private Integer p1_score_article;         //   int comment '得分_文章',
    private Integer p1_score_articleMa;       // int comment '得分_文章max',
    private Integer p1_score_platform;        //   int comment '得分_平台',
    private Integer p1_score_platformMa;      // int comment '得分_平台max',
    private Integer p1_score_upward;          //   int comment '得分_上升力',
    private Integer p1_score_upwardMa;        // int comment '得分_上升力max',
    private Integer p1_score_funding;         //   int comment '得分_经费',
    private Integer p1_score_fundingMa;       // int comment '得分_经费max',
    private Integer p1_score_contacts;        //   int comment '得分_人脉',
    private Integer p1_score_contactsMa;      // int comment '得分_人脉max',
    private Integer p2_five_yearMa;           // int comment '[业界水平(百分制)]五年最高因子',
    private Integer p2_H_index;               //   int comment '[业界水平(百分制)]H-index',
    private Integer p2_five_year_one_cot;     // int comment '[业界水平(百分制)]近五年一作量',
    private Integer p2_text_first_article;    //   int comment '[xx-xx年]第一作者文章量',
    private Integer p2_text_max_factor;       //   int comment '[xx-xx年]最高因子',
    private Integer p2_text_H_index;          //   int comment '[xx-xx年]H-index',
    private Integer p3_text_n1;               //   int comment '合作者数量',
    private Integer p3_data_d1;               //   int comment '[业界水平(百分制)]合作者数量',
    private String  p3_text_v2;               //  varchar(64) comment '出国经历',
    private Integer p3_text_d2;               //   int comment '[业界水平(百分制)]出国经历',
    private String  p3_text_v3;               //  varchar(64) comment '主要职称',
    private Integer p3_text_d3;               //   int comment '[业界水平(百分制)]主要职称',
    private String  p3_text_v4;               //  varchar(64) comment '重要职务',
    private Integer p3_text_d4;               //   int comment '[业界水平(百分制)]重要职务',
    private String  p3_text_v5;               //  varchar(64) comment '担任编辑',
    private Integer p3_text_d6;               //   int comment '[业界水平(百分制)]担任编辑',
    private String  end_text_n1;              //  varchar(256) comment '研究方向',
    private String  end_text_n2;              //  varchar(256) comment '导师画像',
    private String  end_text_n3;              //  varchar(256) comment '硕士发文可能性'

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName0() {
        return name0;
    }

    public void setName0(String name0) {
        this.name0 = name0;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getP1_score_article() {
        return p1_score_article;
    }

    public void setP1_score_article(Integer p1_score_article) {
        this.p1_score_article = p1_score_article;
    }

    public Integer getP1_score_articleMa() {
        return p1_score_articleMa;
    }

    public void setP1_score_articleMa(Integer p1_score_articleMa) {
        this.p1_score_articleMa = p1_score_articleMa;
    }

    public Integer getP1_score_platform() {
        return p1_score_platform;
    }

    public void setP1_score_platform(Integer p1_score_platform) {
        this.p1_score_platform = p1_score_platform;
    }

    public Integer getP1_score_platformMa() {
        return p1_score_platformMa;
    }

    public void setP1_score_platformMa(Integer p1_score_platformMa) {
        this.p1_score_platformMa = p1_score_platformMa;
    }

    public Integer getP1_score_upward() {
        return p1_score_upward;
    }

    public void setP1_score_upward(Integer p1_score_upward) {
        this.p1_score_upward = p1_score_upward;
    }

    public Integer getP1_score_upwardMa() {
        return p1_score_upwardMa;
    }

    public void setP1_score_upwardMa(Integer p1_score_upwardMa) {
        this.p1_score_upwardMa = p1_score_upwardMa;
    }

    public Integer getP1_score_funding() {
        return p1_score_funding;
    }

    public void setP1_score_funding(Integer p1_score_funding) {
        this.p1_score_funding = p1_score_funding;
    }

    public Integer getP1_score_fundingMa() {
        return p1_score_fundingMa;
    }

    public void setP1_score_fundingMa(Integer p1_score_fundingMa) {
        this.p1_score_fundingMa = p1_score_fundingMa;
    }

    public Integer getP1_score_contacts() {
        return p1_score_contacts;
    }

    public void setP1_score_contacts(Integer p1_score_contacts) {
        this.p1_score_contacts = p1_score_contacts;
    }

    public Integer getP1_score_contactsMa() {
        return p1_score_contactsMa;
    }

    public void setP1_score_contactsMa(Integer p1_score_contactsMa) {
        this.p1_score_contactsMa = p1_score_contactsMa;
    }

    public Integer getP2_five_yearMa() {
        return p2_five_yearMa;
    }

    public void setP2_five_yearMa(Integer p2_five_yearMa) {
        this.p2_five_yearMa = p2_five_yearMa;
    }

    public Integer getP2_H_index() {
        return p2_H_index;
    }

    public void setP2_H_index(Integer p2_H_index) {
        this.p2_H_index = p2_H_index;
    }

    public Integer getP2_five_year_one_cot() {
        return p2_five_year_one_cot;
    }

    public void setP2_five_year_one_cot(Integer p2_five_year_one_cot) {
        this.p2_five_year_one_cot = p2_five_year_one_cot;
    }

    public Integer getP2_text_first_article() {
        return p2_text_first_article;
    }

    public void setP2_text_first_article(Integer p2_text_first_article) {
        this.p2_text_first_article = p2_text_first_article;
    }

    public Integer getP2_text_max_factor() {
        return p2_text_max_factor;
    }

    public void setP2_text_max_factor(Integer p2_text_max_factor) {
        this.p2_text_max_factor = p2_text_max_factor;
    }

    public Integer getP2_text_H_index() {
        return p2_text_H_index;
    }

    public void setP2_text_H_index(Integer p2_text_H_index) {
        this.p2_text_H_index = p2_text_H_index;
    }

    public Integer getP3_text_n1() {
        return p3_text_n1;
    }

    public void setP3_text_n1(Integer p3_text_n1) {
        this.p3_text_n1 = p3_text_n1;
    }

    public Integer getP3_data_d1() {
        return p3_data_d1;
    }

    public void setP3_data_d1(Integer p3_data_d1) {
        this.p3_data_d1 = p3_data_d1;
    }

    public String getP3_text_v2() {
        return p3_text_v2;
    }

    public void setP3_text_v2(String p3_text_v2) {
        this.p3_text_v2 = p3_text_v2;
    }

    public Integer getP3_text_d2() {
        return p3_text_d2;
    }

    public void setP3_text_d2(Integer p3_text_d2) {
        this.p3_text_d2 = p3_text_d2;
    }

    public String getP3_text_v3() {
        return p3_text_v3;
    }

    public void setP3_text_v3(String p3_text_v3) {
        this.p3_text_v3 = p3_text_v3;
    }

    public Integer getP3_text_d3() {
        return p3_text_d3;
    }

    public void setP3_text_d3(Integer p3_text_d3) {
        this.p3_text_d3 = p3_text_d3;
    }

    public String getP3_text_v4() {
        return p3_text_v4;
    }

    public void setP3_text_v4(String p3_text_v4) {
        this.p3_text_v4 = p3_text_v4;
    }

    public Integer getP3_text_d4() {
        return p3_text_d4;
    }

    public void setP3_text_d4(Integer p3_text_d4) {
        this.p3_text_d4 = p3_text_d4;
    }

    public String getP3_text_v5() {
        return p3_text_v5;
    }

    public void setP3_text_v5(String p3_text_v5) {
        this.p3_text_v5 = p3_text_v5;
    }

    public Integer getP3_text_d6() {
        return p3_text_d6;
    }

    public void setP3_text_d6(Integer p3_text_d6) {
        this.p3_text_d6 = p3_text_d6;
    }

    public String getEnd_text_n1() {
        return end_text_n1;
    }

    public void setEnd_text_n1(String end_text_n1) {
        this.end_text_n1 = end_text_n1;
    }

    public String getEnd_text_n2() {
        return end_text_n2;
    }

    public void setEnd_text_n2(String end_text_n2) {
        this.end_text_n2 = end_text_n2;
    }

    public String getEnd_text_n3() {
        return end_text_n3;
    }

    public void setEnd_text_n3(String end_text_n3) {
        this.end_text_n3 = end_text_n3;
    }
}
