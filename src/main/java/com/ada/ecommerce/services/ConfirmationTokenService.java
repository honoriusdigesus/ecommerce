package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.ConfirmationToken;

public interface ConfirmationTokenService {
void save(ConfirmationToken confirmationToken);
ConfirmationToken getByToken(String token);
void setConfirmedAt(ConfirmationToken confirmationToken);
}
