package api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoint {
    ADD_NEW_CONTACT("/api/contact"),
    DELETE_CONTACT_BY_CONTACT_ID("/api/contact/{id}"),
    GET_CONTACT_BY_CONTACT_ID("/api/contact/{id}"),
    UPDATE_CONTACT("/api/contact"),
    ADD_NEW_EMAIL("/api/email"),
    GET_LIST_OF_EMAILS_BY_CONTACT_ID("/api/email/{id}/all");

    private final String value;


}
