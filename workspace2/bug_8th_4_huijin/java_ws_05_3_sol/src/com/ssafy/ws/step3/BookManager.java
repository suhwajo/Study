package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager {
	private static int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	
	public void add(Book book) {
		if(size<MAX_SIZE) {
			books[size++] = book; 			
		}
	}
	
	public void remove(String isbn) {
		for(int i=0;i<size;++i) {
			if(books[i].getIsbn().equals(isbn)) {
				//일치하면 삭제. 맨 마지막 값을 넣어 size를 줄여 삭제함.
				books[i] = books[size-1];
				books[size-1]=null;
				--size;
				break;
			}
		}
	}
	
	public Book[] getList() {
		//MAX_SIZE 까지가 아니고, 총 size 까지만 return
		return Arrays.copyOfRange(books,0,size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<size;++i) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}
