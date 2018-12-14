package com.cg.library.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.library.bean.LibraryBean;
import com.cg.library.exception.LibraryException;
import com.cg.library.util.DbConnection;

public class LibraryDaoImpl implements ILibraryDao
{

	@Override
	public String addBook(LibraryBean libraryBean) throws LibraryException, SQLException, ClassNotFoundException, IOException
	{
		
		Connection connection = DbConnection.getInstance().getConnection();
		//Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		String bookId = null;
		int queryResult = 0;
		
		try
		{
			
			preparedStatement = connection.prepareStatement("insert into Library values(bookId_sequence.nextval,?,?,?,?)");
			preparedStatement.setString(1, libraryBean.getBookName());
			preparedStatement.setString(2, libraryBean.getAuthorName());
			preparedStatement.setDouble(3, libraryBean.getPrice());
			preparedStatement.setLong(4, libraryBean.getQuantity());
			
			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.executeQuery("Select * from Library");
			
			
			while(resultSet.next())
			{
				bookId = resultSet.getString(1);
				libraryBean.getBookId(bookId);				
			}
			return bookId;
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
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

}
