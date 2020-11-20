package com.main.exception;

import com.main.Response;

public class ResponseException extends Exception {

	private static final long serialVersionUID = 1L;
	protected Response mResponse = null;

	public ResponseException(Response response) {
		this.mResponse = response;
	}

	public Response getResponse() {
		return mResponse;
	}
}
