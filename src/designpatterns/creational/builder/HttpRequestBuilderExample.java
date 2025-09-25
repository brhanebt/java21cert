package designpatterns.creational.builder;

interface HttpRequest{
	HttpRequest setMethod(String method);
	HttpRequest setUrl(String url);
	HttpRequest addHeader(String key, String value);
	HttpRequest setBody(String body);
	String build();
}

class HttpRequestBuilder implements HttpRequest{
	private String method;
	private String url;
	private StringBuilder headers;
	private String body;

	public HttpRequestBuilder() {
		this.headers = new StringBuilder();
	}

	public static HttpRequest builder() {
		return new HttpRequestBuilder();
	}

	@Override
	public HttpRequest setMethod(String method) {
		this.method = method;
		return this;
	}

	@Override
	public HttpRequest setUrl(String url) {
		this.url = url;
		return this;
	}

	@Override
	public HttpRequest addHeader(String key, String value) {
		headers.append(key).append(": ").append(value).append("\n");
		return this;
	}

	@Override
	public HttpRequest setBody(String body) {
		this.body = body;
		return this;
	}

	@Override
	public String build() {
		StringBuilder request = new StringBuilder();
		request.append(method).append(" ").append(url).append(" HTTP/1.1\n");
		request.append(headers);
		if(body != null && !body.isEmpty()) {
			request.append("\n").append(body);
		}
		return request.toString();
	}
}

public class HttpRequestBuilderExample {

	public static void main(String[] args) {
		HttpRequest request = HttpRequestBuilder.builder()
				.setMethod("POST")
				.setUrl("/api/data")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer token")
				.setBody("{\"key\":\"value\"}");
		
		System.out.println(request.build());
	}
}
