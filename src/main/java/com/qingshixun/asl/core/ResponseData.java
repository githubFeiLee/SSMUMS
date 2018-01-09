package com.qingshixun.asl.core;

public class ResponseData {
	//״̬��
	public static final String SUCCESS_CODE="0";
	
	public static final String ERROR_CODE="-1";
	
	//��������
	private Object data;
	
	//״̬
	private String status = SUCCESS_CODE;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * ���ô�����Ϣ
	 * @param data
	 */
	public void setError(Object data){
		setStatus(ERROR_CODE);
		setData(data);
	}
	/**
	 * �ж��Ƿ�ɹ�
	 * @return
	 */
	public Boolean isSuccess(){
		return getStatus().equals(SUCCESS_CODE);
	}
}
