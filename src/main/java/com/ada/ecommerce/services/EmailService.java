package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.EmailNotificationDTO;

public interface EmailService {
    void send(EmailNotificationDTO emailNotificationDTO);
}
