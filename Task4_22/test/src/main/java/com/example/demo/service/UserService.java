package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<User> searchAll() {
    return userRepository.findAll();
  }

  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(UserRequest userRequest) {
    Date now = new Date();
    User user = new User();
    user.setTask_name(userRequest.getTask_name());
    user.setTask_status(userRequest.getTask_status());
    user.setStart_date(now);
    user.setEnd_date(now);
    userRepository.save(user);
  } // ★ ここで create メソッドを閉じる

  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public User findById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
  
  /**
   * ユーザー情報 物理削除
   * @param id ユーザーID
   */
  public void delete(Long id) {
    User user = findById(id);
    userRepository.delete(user);
  }

    /**
     * ユーザー情報 更新
     * @param user ユーザー情報
     */
    public void update(UserUpdateRequest userUpdateRequest) {
      User user = findById(userUpdateRequest.getTask_id());
      user.setTask_status(userUpdateRequest.getTask_status());
      user.setTask_name(userUpdateRequest.getTask_name());
      user.setStart_date(new Date());
      userRepository.save(user);
    
  }
}
