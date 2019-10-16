package com.techelevator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.DateFormatSymbols;
import javax.sql.DataSource;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;
import com.techelevator.model.Campground;
import com.techelevator.model.CampgroundDAO;
import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;
import com.techelevator.model.ReservationDAO;
import com.techelevator.model.Site;
import com.techelevator.model.SiteDAO;
import com.techelevator.model.jdbc.JDBCCampgroundDAO;
import com.techelevator.model.jdbc.JDBCParkDAO;
import com.techelevator.model.jdbc.JDBCReservationDAO;
import com.techelevator.model.jdbc.JDBCSiteDAO;

public class CampgroundCLI {
	
	
	private static final String MAIN_MENU_REQUEST_TO_SEE_PARKS = "Yes";
	private static final String MAIN_MENU_OPTION_EXIT = "No";
	private static final String[] MAIN_MENU_OPTIONS = new String[] {MAIN_MENU_REQUEST_TO_SEE_PARKS, MAIN_MENU_OPTION_EXIT};
	
	private static final String PARK_MENU_VIEW_CAMPGROUNDS = "View Campgrounds";
//	private static final String PARK_MENU_SEARCH_FOR_RESERVATION = "Search for Reservation";
	private static final String PARK_MENU_OPTION_EXIT = "Return to Main Screen";
	private static final String[] PARK_MENU_OPTIONS = new String[] {PARK_MENU_VIEW_CAMPGROUNDS, PARK_MENU_OPTION_EXIT};
	
	private static final String CAMPGROUND_MENU_VIEW_RESERVATIONS = "Search for Available Reservation";
	private static final String CAMPGROUND_MENU_RETURN_TO_PREVIOUS_SCREEN = "Return to Previous Screen";
	private static final String[] CAMPGROUND_MENU_OPTIONS = new String[] {CAMPGROUND_MENU_VIEW_RESERVATIONS, CAMPGROUND_MENU_RETURN_TO_PREVIOUS_SCREEN};
	
	
	private Menu menu;
	private ParkDAO parkDAO;
	private CampgroundDAO campgroundDAO;
	private ReservationDAO reservationDAO;
	private SiteDAO siteDAO;
	
	public static void main(String[] args) {
		CampgroundCLI application = new CampgroundCLI();
		application.run();
	}

	public CampgroundCLI() {
		this.menu = new Menu(System.in, System.out);
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		// create your DAOs here
		parkDAO = new JDBCParkDAO(dataSource);
		campgroundDAO = new JDBCCampgroundDAO(dataSource);
		reservationDAO = new JDBCReservationDAO(dataSource);
		siteDAO = new JDBCSiteDAO(dataSource);

	}

	public void run() {
		while(true) {
			printHeading("Would you like to view all available parks?");
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//			System.out.println("Would you like to view all available parks?");
			if(choice.equals(MAIN_MENU_REQUEST_TO_SEE_PARKS)) {
				handleParks();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank You! Have a nice day!");
				System.exit(0);
			}
		}
	}
	
	
	private void handleParks() {
		printHeading("National Parks");
		System.out.println("Please choose a park to view park information.");
		List<Park> myParks = parkDAO.getAllParks();
		String[] all_park_options = new String[myParks.size() +1];
		int index = 0;
		for (Park value : myParks) {
			all_park_options[index] = value.getName();
			index++;
		}
		all_park_options[index] = "Quit";
		String choice = (String)menu.getChoiceFromOptions(all_park_options);
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		if(choice.equals(all_park_options[0])) {
			handleParksInformation(choice);
		} else if(choice.equals(all_park_options[1])) {
			handleParksInformation(choice);
		} else if(choice.equals(all_park_options[2])) {
			handleParksInformation(choice);
		} else if(choice.equals(all_park_options[3])) {
			handleParksInformation(choice);
		} 
	}
	
	private void handleParksInformation(String choice) {
		List<Park> myParks = parkDAO.getParkByName(choice);
		Park p = myParks.get(0);
		Long id = p.getId();
		System.out.println("\nPark Information Screen");
		System.out.println(p.getName() + " National Park");
		System.out.format("%-20s %s %n", "Location: ", p.getLocation());
		System.out.format("%-20s %s %n", "Established: ", p.getDate());
		System.out.format("%-20s %,d sq km%n", "Area: ", p.getArea());
		System.out.format("%-20s %,d%n", "Annual Visitors: ",p.getVisitors());
		System.out.println();
		System.out.println("Select a Command: ");

		String campgroundOptions = (String)menu.getChoiceFromOptions(PARK_MENU_OPTIONS);
		if(campgroundOptions.equals(PARK_MENU_VIEW_CAMPGROUNDS)) {
			handleCampgroundInfo(id, choice);
		} else if(campgroundOptions.equals(PARK_MENU_OPTION_EXIT)) {
			
		}
		
	}
	
	
	private void handleCampgroundInfo(Long id, String choice) {
		
		List<Campground> myCampgrounds = campgroundDAO.getCampgroundByParkId(id);
			
		int i = 1;
		
		String newDate = null;
		String secondNewDate = null;
		System.out.println("");
		System.out.format("%10s %31s %31s %24s", "Name", "Open", "Close", "Daily Fee");
		System.out.println("");
		for (Campground campground : myCampgrounds) {
			int strDate = Integer.parseInt(campground.getOpenFromMonth());
			int secondStrDate = Integer.parseInt(campground.getOpenToMonth());
			newDate = getMonth(strDate);
			secondNewDate = getMonth(secondStrDate);
			
			System.out.format("%-5d %-31s %-30s %-20s $%-10.2f", i, campground.getName(), newDate, secondNewDate, campground.getDailyFee());
			System.out.println("");
			i++;

		}
		
		
		String campgroundReservationOptions = (String)menu.getChoiceFromOptions(CAMPGROUND_MENU_OPTIONS);
		if(campgroundReservationOptions.equals(CAMPGROUND_MENU_VIEW_RESERVATIONS)) {
			// Call method to do stuff
			handleGetReservationPage(id);
		} else if(campgroundReservationOptions.equals(CAMPGROUND_MENU_RETURN_TO_PREVIOUS_SCREEN)) {
			// Call first method
			handleParksInformation(choice);
		}
		
	}
	
	
	private void handleGetReservationPage(Long id) {
		
		List<Campground> myCampgrounds = campgroundDAO.getCampgroundByParkId(id);
		String[] campground_reservation_option = new String[myCampgrounds.size()];	
		int index = 0;
		int i = 1;
		String newDate = null;
		String secondNewDate = null;
		System.out.println("");
		System.out.println("---------------------------------------------------------------");
		System.out.println("PLEASE ENTER THE CAMPGROUND YOU WOULD LIKE BELOW");
		System.out.println("");
		System.out.println("");
		System.out.format("%10s %21s %11s %16s", "Name", "Open", "Close", "Daily Fee \n");

		
			for (Campground campground : myCampgrounds) {
				campground_reservation_option[index] = campground.getName();
				int strDate = Integer.parseInt(campground.getOpenFromMonth());
				int secondStrDate = Integer.parseInt(campground.getOpenToMonth());
				newDate = getMonth(strDate);
				secondNewDate = getMonth(secondStrDate);
				System.out.format("%-5d %-21s %-10s %-10s $%-10.2f", i, campground.getName(), newDate, secondNewDate, campground.getDailyFee());
				System.out.println("");
				i++;
				index++;
			}
			
		// Take in userInput for selected number and create scanner
		Scanner reader = new Scanner(System.in);
		System.out.println("\nEnter a campground number: ");
		int campgroundNumber = reader.nextInt();
		int campgroundIndex = campgroundNumber - 1;
		Long campgroundId = myCampgrounds.get(campgroundIndex).getCampgroundId();
		System.out.println("Please enter an arrival date in the form mm/dd/yyyy: ");
		String arrivalDate = reader.next();
		System.out.println(" ");
		System.out.println("Please enter a departure date in the form mm/dd/yyyy: ");
		String departureDate = reader.next();
		System.out.println(" ");

		
		// Call a method that will take in all my userInput and display 
		handleDisplayReservationResults(id, campgroundId, arrivalDate, departureDate);
		
	}
	
	public void handleDisplayReservationResults(Long id, Long campgroundId, String arrivalDate, String departureDate) {
		List<Site> mySites = new ArrayList<Site>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate myArrival = LocalDate.parse(arrivalDate, formatter);
		LocalDate myDeparture = LocalDate.parse(departureDate, formatter);
		
		Long numDays = ChronoUnit.DAYS.between(myArrival, myDeparture);
		Double cost = campgroundDAO.getCampgroundCost(id, campgroundId);
		Double totalCost = cost*numDays;
		
		
		System.out.println("Results Matching Your Search Criteria");
		System.out.format("%-10s %-10s %-15s %-15s %-10s %-10s", "Site_No", "Max_Occup.", "Accessible?", "Max_Rv_Length", "Utilities", "Total Cost\n");
		
		
		mySites = siteDAO.getAllAvailableSitesForReservation(campgroundId, arrivalDate, departureDate);
		
		for (Site site : mySites) {
			String yesOrNo = "No";
			String otherYesOrNo = "No";
			if (site.isAccessible()==true) {
				yesOrNo = "Yes";
			}
			if (site.isUtilities()==true) {
				otherYesOrNo = "Yes";
			}
			System.out.format("%-10d %-10d %-15s %-15d %-10s $%-10.2f\n",site.getSiteNumber(), site.getMaxOccupancy(), yesOrNo, site.getMaxRvLength(), otherYesOrNo, totalCost);
		}
		handleReservationAssignment(myArrival, myDeparture);
	}
	
	public void handleReservationAssignment(LocalDate myArrival, LocalDate myDeparture) {
		
		Scanner newReader = new Scanner(System.in);
		System.out.println("\nWhich site should be reserved (enter 0 to cancel)? ");
		Long siteId = newReader.nextLong();
		if (siteId == 0) {
			System.out.println("Stop that!");
			handleReservationAssignment(myArrival, myDeparture);
		}
		System.out.println("What name should the reservation be made under? ");
		String reservationName = newReader.next();
		System.out.println(" ");
		
		String response = reservationDAO.updateReservationList(siteId, reservationName, myArrival, myDeparture);
		
		if (response.equals("Reservation cannot be made.")) {
			
		}
		System.out.println(response);
	}
	
	
	
	
	
	private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}
}