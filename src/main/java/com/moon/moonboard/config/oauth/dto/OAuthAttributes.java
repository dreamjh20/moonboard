package com.moon.moonboard.config.oauth.dto;

import java.util.Map;

public class OAuthAttributes {
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

}
