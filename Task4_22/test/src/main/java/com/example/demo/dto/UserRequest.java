package com.example.demo.dto;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 100, message = "名前は100桁以内で入力してください")
  private String task_name;
  /**
   * タスク状況
   */
  @Size(max = 255, message = "タスク状況は255桁以内で入力してください")
  private String task_status;
  /**
   * ユーザー情報 Repository
   */
  @Repository
  public interface UserRepository extends JpaRepository<User, Long> {}
}