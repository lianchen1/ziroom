package util.SendMsgDemo1;

public class SendMsg {
	public static void main(String[] args) {
		String mobileNumber = "18502511193";//������֤����ֻ�����
		try {
			String str = MobileMessageSend.sendMsg(mobileNumber);
			if("success".equals(str)){
				System.out.println("���ͳɹ���");
			}else{
				System.out.println("����ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
