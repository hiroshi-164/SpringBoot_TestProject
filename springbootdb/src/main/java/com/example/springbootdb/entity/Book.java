package com.example.springbootdb.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the "sample" database table.
 * 
 */
@Entity
@Table(name = "Book", schema = "public")
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	// コンストラクタ
	public Book() {
	}

	public Book(String bookTitle, String writerName, String status) {
		this.bookTitle = bookTitle;
		this.writerName = writerName;
		this.status = status;
	}

	@Id // 主キーを指定
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動インクリメントを指定
	@Column(name = "No") // テーブルの No カラムにマッピング
	private Long no; // 自動インクリメントされる主キー

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "writer_name")
	private String writerName;

	@Column(name = "status")
	private String status;

	// ゲッターとセッター

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
