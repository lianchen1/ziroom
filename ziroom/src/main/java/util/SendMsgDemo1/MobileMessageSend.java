package util.SendMsgDemo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class MobileMessageSend {
	private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";//������֤�������·��URL
	private static final String APP_KEY="a75690afa09255f6ad7a1593b6ad8ab5";//�������ŷ�����˺�
	private static final String APP_SECRET="26a9c6832a45";//�������ŷ������Կ
	private static final String NONCE="123456";//�����

	public static String sendMsg(String phone) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(SERVER_URL);

		String curTime=String.valueOf((new Date().getTime()/1000L));
		String checkSum=CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);

		//���������header
		post.addHeader("AppKey",APP_KEY);
		post.addHeader("Nonce",NONCE);
		post.addHeader("CurTime",curTime);
		post.addHeader("CheckSum",checkSum);
		post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

		//�����������
		List<NameValuePair> nameValuePairs =new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("mobile",phone));

		post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

		//ִ������
		HttpResponse response=httpclient.execute(post);
		String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");

		//�ж��Ƿ��ͳɹ������ͳɹ�����true
		String code= JSON.parseObject(responseEntity).getString("code");
		if (code.equals("200")){
			return "success";
		}
		return "error";
	}
}
