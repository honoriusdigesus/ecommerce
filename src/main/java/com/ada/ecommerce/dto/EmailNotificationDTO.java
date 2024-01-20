package com.ada.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmailNotificationDTO {
    String to;
    String subject;
    String body;
    boolean hasTemplate;
}
