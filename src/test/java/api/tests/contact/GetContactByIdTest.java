package api.tests.contact;

import api.EndPoint;
import api.model.ContactDto;
import api.tests.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetContactByIdTest extends ApiBase {
    Response response;
    ContactDto contactDto;
    int id;

    @BeforeMethod
    public void precondition(){
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
    public void getContactByIdTest(){
        response = doGetRequestWithParam(id, EndPoint.DELETE_CONTACT_BY_CONTACT_ID, 200);

        Assert.assertEquals(response.jsonPath().getInt("id"), id);
        Assert.assertEquals(response.jsonPath().getString("firstName"),contactDto.getFirstName());
        Assert.assertEquals(response.jsonPath().getString("lastName"),contactDto.getLastName());
        Assert.assertEquals(response.jsonPath().getString("description"),contactDto.getDescription());
    }
}
