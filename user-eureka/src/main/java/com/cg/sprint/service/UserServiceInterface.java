package com.cg.sprint.service;

import java.util.List;
//user
import com.cg.sprint.entity.Account;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.Languages;
import com.cg.sprint.entity.Movies;
import com.cg.sprint.entity.Payments;
import com.cg.sprint.entity.Refund;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;

public interface UserServiceInterface {

	Account validate(String uname, String pass);
	Account save(Account a);
	List<City> getCityNames();
	List<Theatre> theatreNames(String name);
	List<Movies> movieNames(String name);
	List<Shows> getShows();
	List<Languages> getLanguage();
	List<Seats> getSeats();
	Customer getAccountData(int acc_no);
	String updateSeats(Seats seat_obj);
	String payments(Payments pay);
	Payments refund(int acc_no, int book_id);
	String updatePayment(Payments pay);
	String refundDetails(Refund ref);
	Seats seatDetails(String s_type);
	String setSeats(Seats seat);
	String updateCustomer(Customer cus);	
}
