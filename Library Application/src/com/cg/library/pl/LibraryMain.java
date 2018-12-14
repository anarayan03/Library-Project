package com.cg.library.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.library.bean.LibraryBean;
import com.cg.library.exception.LibraryException;
import com.cg.library.service.IlibraryService;
import com.cg.library.service.LibraryServiceImpl;

public class LibraryMain
{
	
	static Scanner scanner = new Scanner(System.in);
	static IlibraryService ilibraryService = null;
	static LibraryServiceImpl libraryServiceImpl = null;
	
	public static void main(String[] args) 
	{
		LibraryBean libraryBean = null;
		String bookId = null;
		int option = 0;
		
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("	LIBRARY	");
			System.out.println("----------------------------");
			System.out.println("1. Add Book :");
			System.out.println("2. View Book");
			System.out.println("3. Issue Book");
			System.out.println("4. Accept Book");
			System.out.println("5. Exit");
			System.out.println("____________________________");
			System.out.println("Enter your Choice ");
			
			try
			{
				option = scanner.nextInt();
				
				switch (option) 
				{
				case 1 :
					
					while(libraryBean==null)
					{
						libraryBean=populateLibraryBean();
					}
					try
					{
						libraryServiceImpl = new LibraryServiceImpl();
						bookId=libraryServiceImpl.addBook(libraryBean);
						System.out.println("Book details has been successfully entered....");
						System.out.println("Book ID is :"+ bookId);
					}catch (LibraryException libraryException) {
						System.out.println("ERROR :" + libraryException.getMessage());
					}
					finally
					{
						bookId = null;
						libraryServiceImpl = null;
						libraryBean = null;
					}
					
					break;
			    
				case 2 :
					
					break;
					
				case 3 :
	
					break;
					
				case 4 :
	
					break;
	
				case 5 :
	
					break;
					
				default:
					
					break;
				}
				
			}catch (Exception e)
			{
				System.out.println(e);
			}
			
		}
		
	}

	private static LibraryBean populateLibraryBean()
	{
		
		LibraryBean libraryBean = new LibraryBean();
		System.out.println("Enter Book Details :");
		
		System.out.println("\nEnter Book Name : ");
		libraryBean.setBookName(scanner.next());
		
		System.out.println("Enter Author Name : ");
		libraryBean.setAuthorName(scanner.next());
		
		System.out.println("Enter Book's Price : ");
		try
		{
		libraryBean.setPrice(scanner.nextDouble());
		}catch (InputMismatchException e)
		{
			System.err.println("Please enter a numeric value for donation amount, try again");
		}
		
		System.out.println("Enter Books Quantity :");
		libraryBean.setQuantity(scanner.nextLong());
		
		libraryServiceImpl = new LibraryServiceImpl();
		
		try
		{
			libraryServiceImpl.validateLibraryAttribute(libraryBean);
			return libraryBean;
		}catch (LibraryException libraryException) {
			System.out.println("Invalid Data");
			System.err.println(libraryException);
			System.exit(0);
		}
		
		return null;
	}
}
