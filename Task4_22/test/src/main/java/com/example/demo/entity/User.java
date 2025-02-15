package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "task")
public class User implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "task_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long task_id;
  /**
   * タスク名
   */
  @Column(name = "task_name")
  private String task_name;
  /**
   * タスク状況
   */
  @Column(name = "task_status")
  private String task_status;
  /**
   * 作成日
   */
  @CreationTimestamp
  @Column(name = "start_date")
  private Date start_date;
  /**
   * 完了日
   */
  @Column(name = "end_date")
  private Date end_date;
}