package api.test;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.*;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class MRO {

	@Test
	public void TestPostUser() {

		APIFunctions API = new APIFunctions("baseUrl");
		RestAssured.config=RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames().relaxedHTTPSValidation());
		System.out.println(baseURI);
		String requestbody = "{\"woNo\":\"45593252\",\"notifNo\":\"305226638\",\"plant\":\"2052\",\"text\":\"Test\",\"commentDate\":\"08/14/24\",\"commentUser\":\"Suresh kode\"}";
		Response postRequest = API.postRequest("comment/create", requestbody,
				"Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVF9RQSIsInBpLmF0bSI6Imt1bmYiLCJ0eXAiOiJKV1QifQ.eyJzY29wZSI6Im9wZW5pZCIsImF1dGhvcml6YXRpb25fZGV0YWlscyI6W10sImNsaWVudF9pZCI6Ik1ST0xpZmUtcWEiLCJpc3MiOiJodHRwczovL2xvZ2lucWEucm9ja3dlbGxjb2xsaW5zLmNvbTo0NDMiLCJhdWQiOiJodHRwczovL2xvZ2lucWEucm9ja3dlbGxjb2xsaW5zLmNvbTo0NDMiLCJqdGkiOiJVN3BxQSIsInN1YiI6IkU0MDAyMzM2NEBhZHh1c2VyLmNvbSIsImlzVVNQZXJzb24iOiJubyIsIm1haWwiOiJTdXJlc2guS29kZUBjb2xsaW5zLmNvbSIsImdpdmVuTmFtZSI6IlN1cmVzaCIsInBpLnNyaSI6IllPS0xSSWRSM2x0eHpmVjRxVXd5TE9mc0NYVSIsIldvcmtEYXlFbXBsb3llZUlEIjoiMDAwNDAwMjMzNjQiLCJzbiI6IktvZGUiLCJHbG9iYWxVSUQiOiIxMDAwNDAwMjMzNjQiLCJpYXQiOjE3MjM2MzQ0MjYsInVzZXJQcmluY2lwYWxOYW1lIjoiRTQwMDIzMzY0QGFkeHVzZXIuY29tIiwiZXhwIjoxNzIzNjQxNjI2fQ.ZMN4_kdTZiharu3js_pjZe6NENJ1xq1H5O1nf8Ium1Uf2RizH9rVIosIZu17CTasQ05YWQ_qfGX-gPg6gvqccKj0zZoxHNesb7LehoupIigmu2RlopT8EWtDkWV_CdPOzKQOU-dP-AVV94mFUSAvW6KsYPTqcInv9y2YDPIWxHMdza7v6i-LWFTChUuiJnbBXCxP5I44Ua0Oo5JtMtj6Y7tzayZqcIxiSIZIoKZBWzeuYyrur3sGpidPo2VI8f6Iam_9ZozSwZl_IEqfYu5wYmvpJ7MQUC5FIDlLZfpv0PUDqKGpYzrV0hxUnG8ytWKd-IITwiTi-gUHzAnfvuK1oA");
		postRequest.then().statusCode(200);
		System.out.println(postRequest.print());

	}

}

