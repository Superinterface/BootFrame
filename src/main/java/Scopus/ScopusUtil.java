package Scopus;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


    /**
     * [Project]:whymoy  <br/>
     * [Email]:moy25@foxmail.com  <br/>
     * [Date]:2018/3/14  <br/>
     * [Description]:  <br/>
     *
     * @author YeXiangYang
     */
    public  class ScopusUtil {

        public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
            String htmlid="resultDataRow";
            String url = "https://www.scopus.com/results/authorNamesList.uri?sort=count-f&src=al&affilName=South%20China%20Agricultural%20University&st1=wang&st2=wei";
            try (CloseableHttpClient httpClient = createHttpClient()) {
                HttpGet httpGet = new HttpGet(url);
                httpGet.getParams().setParameter("http.protocol.allow-circular-redirects", true);
                try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                    HttpEntity entity = httpResponse.getEntity();
                    String result = EntityUtils.toString(entity);
                    EntityUtils.consume(entity);
                  //  System.out.println(result);
                    Document document = Jsoup.parse(result);
                    //像js一样，通过id 获取文章列表元素对象
                    for(int i=1;i>=1;i++) {
                        Element postList = document.getElementById(htmlid+i);
                        if(postList==null){
                            break;
                        }
                        Elements WwZ = postList.getElementsByAttributeValue("name", "authorIds");
                        Elements WwGsjg = postList.getElementsByClass("anchorText");
                        System.out.println("姓名：" + WwZ.attr("data-name"));
                        System.out.println("归属机构：" + WwGsjg.text());
                        System.out.println("文献数量：" + WwZ.attr("data-doccount"));
                        System.out.println("用户id：" + WwZ.attr("value"));
                    }
                }
            }
        }


        private static CloseableHttpClient createHttpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
            SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, (chain, authType) -> true)
                    .build();

            SSLConnectionSocketFactory sslSf = new SSLConnectionSocketFactory(sslcontext, null, null,
                    new NoopHostnameVerifier());

            return HttpClients.custom().setSSLSocketFactory(sslSf).build();
        }
    }

