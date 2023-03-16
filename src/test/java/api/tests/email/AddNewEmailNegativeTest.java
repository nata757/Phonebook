package api.tests.email;

import api.EndPoint;
import api.model.EmailDto;
import api.tests.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewEmailNegativeTest extends ApiBase {
    Response response;
    int wrongId = getWrongId();
    String errorMessage = "Error! This contact doesn't exist in our DB";
    EmailDto emailDto;

    @Test
    public void addNewEmailNegativeTest(){
        emailDto = new EmailDto();
        emailDto.setEmail(faker.internet().emailAddress());
        emailDto.setContactId(wrongId);

        response = doPostRequest(emailDto, EndPoint.ADD_NEW_EMAIL, 500);

        Assert.assertEquals(response.jsonPath().getString("message"),errorMessage);
    }
}
