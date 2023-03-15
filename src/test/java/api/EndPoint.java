package api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoint {
    ADD_NEW_CONTACT("/api/contact"),
    DELETE_CONTACT_BY_CONTACT_ID("/api/contact/{id}");
    private final String value;


}
