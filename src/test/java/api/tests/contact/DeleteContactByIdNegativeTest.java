package api.tests.contact;

import api.EndPoint;
import api.tests.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactByIdNegativeTest extends ApiBase {
    Response response;
    int wrongId = getWrongId();
    String errorMessage = "Error! This contact doesn't exist in our DB";


@Test
    public void deleteContactByWrongId(){
    response = doDeleteRequest(wrongId, EndPoint.DELETE_CONTACT_BY_CONTACT_ID, 500);
    Assert.assertEquals(response.jsonPath().getString("message"), errorMessage);
   }

}
