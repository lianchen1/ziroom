package util.SendMsgDemo2;

public class CheckMsg {
	public static void main(String[] args) {
		String mobileNumber = "18502511193";//�ֻ�����
		String code = "6607";//��֤��
		try {
			String str = MobileMessageCheck.checkMsg(mobileNumber,code);
			if("success".equals(str)){
				System.out.println("��֤�ɹ���");
			}else{
				System.out.println("��֤ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
