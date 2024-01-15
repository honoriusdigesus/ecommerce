package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.ConfirmationToken;
import com.ada.ecommerce.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{
  private ConfirmationTokenRepository confirmationTokenRepository;

  @Override
  public void save(ConfirmationToken confirmationToken) {
    confirmationTokenRepository.save(confirmationToken);
  }
}
