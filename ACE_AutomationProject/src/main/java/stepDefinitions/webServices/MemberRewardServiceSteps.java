package stepDefinitions.webServices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pageObject.webservices_entity.Reward;
import utils.Config;


public class MemberRewardServiceSteps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	HashMap<String, Reward> value ;


	private String ENDPOINT_GET_MEMBER_REWARDS = Config.getInstance().getRewardsEndpointURL();

	@Given("^A Member exists in Member Connect Application with unique \"([^\"]*)\"$")
	public void a_Member_exists_in_Member_Connect_Application_with_unique(String memberId) throws Throwable {
		request = given().param("q", memberId);
		System.out.println(request +":request");
	}

	@When("^User calls the Member rewards webservice to retreive with Member Id$")
	public void user_calls_the_Member_rewards_webservice_to_retreive_with_Member_Id() throws Throwable {
		response = request.relaxedHTTPSValidation().when().get(ENDPOINT_GET_MEMBER_REWARDS);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("the status code is (\\d+)")
	public void verifyResponseStatus(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@Then("^user Verifies reward summary as below$")
	public void user_Verifies_reward_summary_as_below(List<Reward> sum) throws Throwable {
		try {
			value = new HashMap<String , Reward>();
			ResponseBody body = response.body();

			for(Reward value : sum) {
				if(body.asString().contains(value.getPoints()) &&
						body.asString().contains(value.getProviderAddress()) &&
						body.asString().contains(value.getProviderName()) &&
						body.asString().contains(value.getRewardDate())&& 
						body.asString().contains(value.getTreatment())) 
				{
					System.out.println("Pass: Response Content validated");
				}
			}}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error: Response Content validation Failed");
			}
	}
	
	@Given("^I want to validate create data api with headers$")
	public void i_want_to_validate_create_data_api_with_headers() throws Throwable {
	  // Write code here that turns the phrase above into concrete actions	
	  request = given();
	  request.header("Content-Type","application/json");
	}


	@When("^I want to create JSON object for request body$")
	public void i_want_to_create_JSON_object_for_request_body() throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
	  JSONObject json = new JSONObject();
	  json.put("text", "hero");
	  json.put("latitude", "40.7127837");
	  json.put("longitude", "-74.00594130000002");
	  json.put("distance", "10000");
	  json.put("sortCriteria", "distanceAsc"); 
	  request.body(json);
	  
	}

	@When("^I want to perform POST call to \"([^\"]*)\"$")
	public void i_want_to_perform_POST_call_to(String arg1) throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
		response = request.post("https://postman-echo.com/post");
	  
	}


	@Then("^I want to verify response code as \"([^\"]*)\"$")
	public void i_want_to_verify_response_code_as(String arg1) throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
		System.out.println(response.getStatusCode());
	//  res.then().assertThat().statusCode(200);
		response.then().assertThat().statusCode(200).and().body("data.text", equalTo("hero"));
	}

	@Given("^I want to input request body payload as a JSON file \"([^\"]*)\"$")
	public void i_want_to_input_request_body_payload_as_a_JSON_file(String inputFile) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		File file = new File(System.getProperty("user.dir")+ inputFile);
		request.body(file).with().contentType("application/json");
		
	    
	}


}




