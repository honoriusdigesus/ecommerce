package com.ada.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "confirmation_tokens")
public class ConfirmationToken {
  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)

  private UUID id;

  @Column(nullable = false)
  private String token;

  @Column(nullable = false)
  private LocalDateTime createAt = LocalDateTime.now();

  private LocalDateTime confirmedAt;

  @Column(nullable = false)
  private LocalDateTime expiresAt;

  @ManyToOne
  @JoinColumn(name = "used_id")
  private User user;

  public ConfirmationToken(String token, LocalDateTime expiresAt, User user) {
    this.token = token;
    this.expiresAt = expiresAt;
    this.user = user;
  }

}
