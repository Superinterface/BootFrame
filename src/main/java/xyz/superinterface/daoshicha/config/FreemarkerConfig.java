package xyz.superinterface.daoshicha.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FreemarkerConfig {
    // Create your Configuration instance, and specify if up to what FreeMarker
    // version (here 2.3.29) do you want to apply the fixes that are not 100%
    // backward-compatible. See the Configuration JavaDoc for details.
    private static Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
    static {
        try {
            initFreemarker();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void initFreemarker() throws IOException {
        // Specify the source where the template files come from. Here I set a
        // plain directory for it, but non-file-system sources are possible too:
        //cfg.setDirectoryForTemplateLoading(new File("/html"));
        cfg.setClassLoaderForTemplateLoading(FreemarkerConfig.class.getClassLoader(), "/static/html");
        // From here we will set the settings recommended for new projects. These
        // aren't the defaults for backward compatibilty.

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

        // Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        cfg.setWrapUncheckedExceptions(true);

        // Do not fall back to higher scopes when reading a null loop variable:
        cfg.setFallbackOnNullLoopVariable(false);
    }

    public Configuration getConfiguration(){
        return cfg;
    }

    public static class Param{
        public static String UTIL = "wkhtmltopdf";
        //public static String PATH = "E:/PDFZ/1.pdf";
        public static String PATH = "/usr/local/webapp/1.pdf";
    }


}
