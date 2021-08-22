package httpData;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRqeusts {
	private static Header[] headeres;
	private CookieStore cookies = new BasicCookieStore();

	public static StringBuffer getCookies() {
		String loginUrl = "https://www.scopus.com/freelookup/form/author.uri?zone=TopNavBar&origin=AuthorProfile";
		HttpClient httpClient = new HttpClient();
		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		GetMethod postMethod = new GetMethod(loginUrl);
		// 设置登陆时要求的信息，用户名和密码
		try {
			// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			int statusCode = httpClient.executeMethod(postMethod);
			// 获得登陆后的 Cookie
			org.apache.commons.httpclient.Cookie[] cookies = httpClient.getState().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
			for (org.apache.commons.httpclient.Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");
			}
			return tmpcookies;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String doPost(String url, String map, String charset, StringBuffer cookies) {
		org.apache.http.client.HttpClient httpClient = null;
		HttpGet httpGet = null;
		String result = null;
		try {

			httpClient = new SSLClient();
			httpGet = new HttpGet(url);
			// 设置参数
			httpGet.addHeader("Host", "www.scopus.com");
			httpGet.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0");
			httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
			httpGet.addHeader("Cookie", cookies.toString());
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

	public static String getindex(String result, String type) {
		JSONObject jsonObjectR = JSONObject.fromObject(result);
		if ("essentialinfo".equals(type)) {
			// 引文
			String citationsCount = jsonObjectR.getString("citationsCount");
			// H-index
			String hindex = jsonObjectR.getString("hindex");
			// 文献被引用数量
			String citedByCount = jsonObjectR.getString("citedByCount");
			// 按作者的文献
			String documentCount = jsonObjectR.getString("documentCount");
			//合著作者
			String coAuthorsCount  = jsonObjectR.getString("coAuthorsCount");
			System.out.println("引文:" + citationsCount);
			System.out.println("H-index:" + hindex);
			System.out.println("文献被引用数量:" + citedByCount);
			System.out.println("按作者的文献:" + documentCount);
			System.out.println("合著作者数量:" + coAuthorsCount);
		}
		if ("Contributioninfo".equals(type)) {
			com.alibaba.fastjson.JSONObject jsonobj = JSON.parseObject(result);
			System.out.println("贡献最高文献时间范围低值:" + jsonobj.getJSONObject("dataSource").getString("metricStartYear"));
			System.out.println("贡献最高文献时间范围高值:" + jsonobj.getJSONObject("dataSource").getString("metricEndYear"));
			JSONArray array = jsonobj.getJSONArray("results");
			for (int i = 0; i < array.size(); i++) {
				com.alibaba.fastjson.JSONObject topic = JSON.parseObject(array.get(i).toString());
				System.out.println("文献名称:" + topic.getJSONObject("topic").getString("name"));
			}

		}
		if ("detailsinfo".equals(type)) {
			com.alibaba.fastjson.JSONObject jsonobj = JSON.parseObject(result);
			JSONArray array = jsonobj.getJSONArray("items");
			for (int i = 0; i < array.size(); i++) {
				com.alibaba.fastjson.JSONObject items = JSON.parseObject(array.get(i).toString());
		        System.out.println("最近发布文献名称:" + items.get("titles"));
		        System.out.println("最近发布文献对应年份:" + items.get("pubYear"));
		        System.out.println("最近发布文献标题:" + items.getJSONObject("source").getString("title"));
			}

		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("最近发布文献名称:");
		StringBuffer cookies = getCookies();
		String essentialinfo = doPost("https://www.scopus.com/api/authors/36072005200", "", "utf-8", cookies);
		String Contributioninfo = doPost("https://www.scopus.com/api/rest/author-metrics/36072005200", "", "utf-8",
				cookies);
		String detailsinfo = doPost(
				"https://www.scopus.com/api/documents/search/preview?authorid=36072005200&sort=plf-f&itemcount=10&offset=0",
				"", "utf-8", cookies);
		String essentialinfoView = getindex(essentialinfo, "essentialinfo");
		String ContributioninfoView = getindex(Contributioninfo, "Contributioninfo");

		String detailsinfoView = getindex(detailsinfo, "detailsinfo");
	}

}
