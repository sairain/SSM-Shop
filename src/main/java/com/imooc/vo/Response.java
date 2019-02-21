package com.imooc.vo;

//封装返回对象
public class Response {

	//处理是否成功
	private boolean success;
	//处理后消息提示
	private String message;
	//返回的数据
	private Object body;
	
	public Response(boolean success,String message){
		this.message=message;
		this.success=success;
	}
	
	public Response(boolean success,String message,Object body){
		this.body=body;
		this.message=message;
		this.success=success;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
}
