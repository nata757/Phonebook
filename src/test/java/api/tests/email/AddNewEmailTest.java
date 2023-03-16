package api.tests.email;

import api.EndPoint;
import api.model.ContactDto;
import api.model.EmailDto;
import api.tests.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewEmailTest  extends ApiBase {
    Response response;
    int id;
    ContactDto contactDto;
    EmailDto emailDto;

    @BeforeMethod
    public void precondition() {
        contactDto = new ContactDto();
        contactDto.setFirstName(faker.name().firstName());
        contactDto.setLastName(faker.name().lastName());
        contactDto.setDescription(faker.lorem().sentence(4));

        response = doPostRequest(contactDto, EndPoint.ADD_NEW_CONTACT, 201);
        id = response.jsonPath().getInt("id");
    }

    @AfterMethod
    public void afterTest() {
        doDeleteRequest(id, EndPoint.DELETE_CONTACT_BY_CONTACT_ID, 200);

    }
    @Test
    public void addNewEmailTest(){
        emailDto = new EmailDto();
        emailDto.setEmail(faker.internet().emailAddress());
        emailDto.setContactId(id);
        doPostRequest(emailDto, EndPoint.ADD_NEW_EMAIL, 201);
        response = doGetRequestWithParam(id, EndPoint.GET_LIST_OF_EMAILS_BY_CONTACT_ID, 200);

        Assert.assertEquals(response.jsonPath().getString("[0].email"),emailDto.getEmail());
        Assert.assertEquals(response.jsonPath().getInt("[0].contactId"),emailDto.getContactId());

    }
}
