package xyz.superinterface.daoshicha.httpData;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class HttpRqeusts {

    public static void main(String[] args) throws IOException {
        String str = doPost("https://www.scopus.com/api/rest/author-metrics/36072005200", "", "utf-8");
        System.out.println(str);
    }

    public static String doPost(String url, String map, String charset) {
        org.apache.http.client.HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpGet = new HttpGet(url);
            //设置参数
            httpGet.addHeader("Host", "www.scopus.com");
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0");
            httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
            httpGet.addHeader("Cookie", "scopusSessionUUID=9a487e2b-011f-40da-b; scopus.machineID=5CE53912E7ABB71DEC8AB01C6186ACCA.i-010cfb13ad631e1c2; AMCV_4D6368F454EC41940A4C98A6%40AdobeOrg=-1124106680%7CMCIDTS%7C18834%7CMCMID%7C10645649636915452840764577495250621113%7CMCAID%7CNONE%7CMCOPTOUT-1627225485s%7CNONE%7CMCAAMLH-1627823085%7C11%7CMCAAMB-1627823085%7Cj8Odv6LonN4r3an7LhD3WZrU1bUpAkFkkiY1ncBR96t2PTI%7CMCSYNCSOP%7C411-18841%7CMCCIDH%7C-947642174%7CvVersion%7C5.2.0; mbox=PC#ce66a8dc57db4357a3db5424ed046009.38_0#1690466043|session#3527d8e30cb14303aaf069dcceae9ca0#1627222472; s_pers=%20v8%3D1627222941559%7C1721830941559%3B%20v8_s%3DFirst%2520Visit%7C1627224741559%3B%20c19%3Dsc%253Asearch%253Aauthor%2520results%7C1627224741560%3B%20v68%3D1627221241633%7C1627224741562%3B; SCSessionID=F7B1DC029EEBAEABCB511C8F6BC1ADAC.i-04bd9a5dc4d98aa62; AWSELB=CB9317D502BF07938DE10C841E762B7A33C19AADB1C88D4A4008719351262724E72B843479DBB729BBB20248BD741CBABF8241F2EFBAFDF2ADE925350150D7900CAD0CA8A6A855375B6C8861506D27AB7E080049E0; SCOPUS_JWT=eyJraWQiOiJjYTUwODRlNi03M2Y5LTQ0NTUtOWI3Zi1kMjk1M2VkMmRiYmMiLCJhbGciOiJSUzI1NiJ9.eyJhbmFseXRpY3NfaW5mbyI6eyJhY2NvdW50TmFtZSI6IlNjb3B1cyBQcmV2aWV3IiwiYWNjb3VudElkIjoiMjc4NjQxIiwidXNlcklkIjoiYWU6MTMzNDEyNTMiLCJhY2Nlc3NUeXBlIjoiYWU6QU5PTjo6R1VFU1Q6In0sInN1YiI6IjEzMzQxMjUzIiwiaW5zdF9hY2N0X25hbWUiOiJTY29wdXMgUHJldmlldyIsInN1YnNjcmliZXIiOmZhbHNlLCJkZXBhcnRtZW50SWQiOiIyODk4MzkiLCJpc3MiOiJTY29wdXMiLCJpbnN0X2FjY3RfaWQiOiIyNzg2NDEiLCJpbnN0X2Fzc29jX21ldGhvZCI6IiIsInBhdGhfY2hvaWNlIjpmYWxzZSwiYXVkIjoiU2NvcHVzIiwibmJmIjoxNjI5MTE5MTcxLCJpbmR2X2lkZW50aXR5X21ldGhvZCI6IiIsImluc3RfYXNzb2MiOiJHVUVTVCIsImluZHZfaWRlbnRpdHkiOiJBTk9OIiwiZXhwIjoxNjI5MTIwMDcxLCJhdXRoX3Rva2VuIjoiZmFlODYzMzMzOTI5YTk0YTk1MGE4Y2Q5MzU2YjZiY2I2ZmJiZ3hycWEiLCJpYXQiOjE2MjkxMTkxNzF9.kUdnFHi0MhOD1XogIlboY-BnHHxxKK4qQqVCfNJ9J2HNbcvj2S8rmNSpyCwq9X-oj7Bwlp7Y9R6bIvGcDbKGguVIn8GfAAe5zvPLZ5RqMrHygZn9U4JaEXFi4gfEzw0VpmoGiM5H2UPJcugAZNoJ5YDVB5x31RabE-MY-GXvOVSTHzD6Q6mFiFyiazGlIkqDw2vV2T-oT_nDFhmVwENX2YTQVf_-syyuNQo8a3KUBVy46iFgcHms3bAvZd_6MRJELPTA0ODkA1NuU6RtxU3ONTTtOvPwyQzoTCC46eMDwwZoLH9SH0C9nJKhnV4n_3qoKtWfyJHZwVdgse1SFciOUA");
            httpGet.addHeader("Upgrade-Insecure-Requests", "1");
            httpGet.addHeader("Pragma", "no-cache");
            httpGet.addHeader("Cache-Control", "no-cache");

            StringEntity stringEntity = new StringEntity(map);
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }





}
