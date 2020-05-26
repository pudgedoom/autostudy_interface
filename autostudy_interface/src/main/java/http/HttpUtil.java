package http;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class HttpUtil {
	public static void get(String url){
		
		try {
			System.out.println(Request.Get(url).execute().returnContent().asString(Consts.UTF_8));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void post(List<Map<String,Object>> list){
		String result=null;
		//post例子
		try {
			result=Request.Post(url).bodyForm(Form.form().add(key, phone).build()).execute().returnContent().asString();
			System.out.println(result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
//		get("https://www.baidu.com");
		post("http://itommy.iteye.com","phone","phone");
	}
}
