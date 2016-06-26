package com.cjzheng.wechat.util;

/**
 * @date: 2016年6月26日下午12:48:56
 * @author: zhengchaojie
 * @version: v1.0
 */

public class NestedException extends RuntimeException {

	private static final long serialVersionUID = 5893258079497055346L;

	private Throwable throwable;

	private NestedException(Throwable t) {
		this.throwable = t;
	}

	/** Wraps another exeception in a RuntimeException. */
	public static RuntimeException wrap(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException) t;
		return new NestedException(t);
	}

	public Throwable getCause() {
		return this.throwable;
	}

	public void printStackTrace() {
		this.throwable.printStackTrace();
	}

}
