package com.cg.library.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.library.bean.LibraryBean;
import com.cg.library.exception.LibraryException;

public interface IlibraryService
{
	public String addBook(LibraryBean libraryBean) throws LibraryException, SQLException, ClassNotFoundException, IOException;
	public LibraryBean viewBook(String bookId) throws LibraryException;
	public LibraryBean issueBook(String bookId) throws LibraryException;
	public LibraryBean acceptBook(String bookId) throws LibraryException;
	
}
