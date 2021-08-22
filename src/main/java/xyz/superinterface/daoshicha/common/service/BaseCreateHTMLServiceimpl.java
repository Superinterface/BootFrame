package xyz.superinterface.daoshicha.common.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.superinterface.daoshicha.common.bean.BsHtmlParam;
import xyz.superinterface.daoshicha.common.dao.BaseMapper;
import xyz.superinterface.daoshicha.config.FreemarkerConfig;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Service
public class BaseCreateHTMLServiceimpl {

    @Autowired
    FreemarkerConfig freemarkerConfig;
    @Resource
    BaseMapper baseMapper;


    public void getData(String name, HttpServletResponse response) throws IOException, TemplateException {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        Configuration cfg = freemarkerConfig.getConfiguration();
        Template t1 = cfg.getTemplate("dsc.html");
        Writer writer = new OutputStreamWriter(out);
        BsHtmlParam findBsHtmlParam = new BsHtmlParam();
        findBsHtmlParam.setName0(name);
        findBsHtmlParam.setName1(name);
        Map root = new HashMap();
        BsHtmlParam p = baseMapper.findBsHtmlParamByName(findBsHtmlParam);
        root.put("p", p);
        t1.process(root, writer);
        out.flush();
    }

    public void createFile(String name) throws IOException {
        Runtime.getRuntime().exec(FreemarkerConfig.Param.UTIL + " http://localhost:8080/daoshicha/api/getHtml?name=" + name + " " + FreemarkerConfig.Param.PATH);
    }


}
