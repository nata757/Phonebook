package api.tests.contact;

import api.EndPoint;
import api.model.contact.ContactDto;
import api.tests.ApiBase;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactByIdTest  extends ApiBase {
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
    @Test
    public void deleteContactBYIdTest(){
doDeleteRequest(id, EndPoint.DELETE_CONTACT_BY_CONTACT_ID,200);
    }

}
