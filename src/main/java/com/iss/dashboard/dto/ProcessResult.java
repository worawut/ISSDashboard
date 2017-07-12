package com.iss.dashboard.dto;

import java.util.List;

public class ProcessResult{
	private static final long serialVersionUID = 1L;

	private boolean flag = false;
	private String code = "";
	private String msg = "";
	private Object Obj = null;
	private int ID = 0;
	private Object obj1 = null;
	private Object obj2 = null;
	private Object obj3 = null;

	private String msgTh;
	private String msgEn;

	private Object exception = null;
	private String msgCode;

	/*
	 * @Override public String toString() { return
	 * ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	 * }
	 */

	@Override
	@SuppressWarnings({ "rawtypes" })
	public String toString() {
		StringBuilder stb = new StringBuilder();
		if (this == null) {
			return null;
		} else {
			stb.append("flag-->" + this.isFlag());
			stb.append(" \ncode-->" + this.getCode());
			stb.append(" \nmsg-->" + this.getMsg());
			if (this.getObj() != null) {
				if (this.getObj() instanceof List) {
					stb.append(" \nobj size-->" + ((List) this.getObj()).size());
				} else {
					stb.append(" \nobj-->" + this.getObj().getClass());
				}
			} else {
				stb.append(" \nobj--> null");
			}

			if (this.getObj1() != null) {
				if (this.getObj1() instanceof List) {
					stb.append(" \nobj1 size-->"
							+ ((List) this.getObj1()).size());
				} else {
					stb.append(" \nobj1-->" + this.getObj1().getClass());
				}
			} else {
				stb.append(" \nobj1--> null");
			}

			stb.append(" \nexception-->" + this.getException());
		}

		return stb.toString();
	}

	/**
	 * @return Returns the exception.
	 */
	public Object getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            The exception to set.
	 */
	public void setException(Object exception) {
		this.exception = exception;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @return
	 */
	public Object getObj() {
		return Obj;
	}

	/**
	 * @param string
	 */
	public void setCode(String string) {
		code = string;
	}

	/**
	 * @param b
	 */
	public void setFlag(boolean b) {
		flag = b;
	}

	/**
	 * @param string
	 */
	public void setMsg(String string) {
		msg = string;
	}

	/**
	 * @param object
	 */
	public void setObj(Object object) {
		Obj = object;
	}

	/**
	 * @return Returns the iD.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param id
	 *            The iD to set.
	 */
	public void setID(int id) {
		ID = id;
	}

	/**
	 * @return Returns the msgEn.
	 */
	public String getMsgEn() {
		return msgEn;
	}

	/**
	 * @param msgEn
	 *            The msgEn to set.
	 */
	public void setMsgEn(String msgEn) {
		this.msgEn = msgEn;
	}

	/**
	 * @return Returns the msgTh.
	 */
	public String getMsgTh() {
		return msgTh;
	}

	/**
	 * @param msgTh
	 *            The msgTh to set.
	 */
	public void setMsgTh(String msgTh) {
		this.msgTh = msgTh;
	}

	/**
	 * @return Returns the flag.
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @return Returns the obj1.
	 */
	public Object getObj1() {
		return obj1;
	}

	/**
	 * @param obj1
	 *            The obj1 to set.
	 */
	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}

	public Object getObj2() {
		return obj2;
	}

	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}

	public Object getObj3() {
		return obj3;
	}

	public void setObj3(Object obj3) {
		this.obj3 = obj3;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
}
