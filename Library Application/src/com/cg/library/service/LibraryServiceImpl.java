package com.cg.library.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.library.bean.LibraryBean;
import com.cg.library.dao.ILibraryDao;
import com.cg.library.dao.LibraryDaoImpl;
import com.cg.library.exception.LibraryException;

public class LibraryServiceImpl implements IlibraryService
{
	
	ILibraryDao ilibrarydao  = new LibraryDaoImpl();
	

	@Override
	public String addBook(LibraryBean libraryBean) throws LibraryException, SQLException, IOException, ClassNotFoundException
	{
		String bookseq;
		bookseq=ilibrarydao.addBook(libraryBean);
		return null;
	}

	@Override
	public LibraryBean viewBook(String bookId) throws LibraryException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibraryBean issueBook(String bookId) throws LibraryException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibraryBean acceptBook(String bookId) throws LibraryException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public void validateLibraryAttribute(LibraryBean libraryBean) throws LibraryException 
	{
		
		List<String> validationError  = new ArrayList<String>();
		
		if(!(isValidName(libraryBean.getBookName())))
		{
			validationError.add("\n Book name should be in alphabet. ");
		}
		
		if(!(isValidAuthorName(libraryBean.getAuthorName())))
		{
			validationError.add("\n Author name should be in alphabet. ");
		}
		
		if(!(isValidPrice(libraryBean.getPrice())))
		{
			validationError.add("\n Price should be positive. ");
		}
		
		if(!(isValidQunatity(libraryBean.getQuantity())))
		{
			validationError.add("\n Quantity should be positive. ");
		}
		
	}

	private boolean isValidQunatity(long quantity) 
	{
		
		return quantity > 0;
	}

	private boolean isValidPrice(double price)
	{
		return price > 0;
	}

	private boolean isValidAuthorName(String authorName)
	{
		
		Pattern pattern = Pattern.compile("[A-Z][a-z]");
		Matcher matcher = pattern.matcher(authorName);
		return matcher.matches();
		
	}

	private boolean isValidName(String bookName)
	{
		
		Pattern pattern = Pattern.compile("[A-Z][a-z]");
		Matcher matcher = pattern.matcher(bookName);
		return matcher.matches();
		
	}

}
