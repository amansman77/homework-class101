/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package net.class101.server1;

import java.util.Scanner;

import net.class101.server1.constant.Constant.UserActionCode;
import net.class101.server1.exception.HasKlassException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.view.MainView;
import net.class101.server1.view.OrderView;

public class App {
	
	private static MainView mainView = new MainView();
	private static OrderView orderView = new OrderView();
	
    public static void main(String[] args) throws SoldOutException, HasKlassException {
    	Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.lineSeparator());
		
    	while (true) {
    		mainView.showOrderOrQuit();
    		
            String action = scanner.next();
            
            if (UserActionCode.ORDER.equals(action)) {
            	mainView.showProducts();
            	System.out.println("");
            	
            	orderView.showOrder(scanner);
            	
            	mainView.showBasket();
            	
            	mainView.showPayment();
            	
            	System.out.println("");
    		} else if (UserActionCode.QUIT.equals(action)) {
    			System.out.print("고객님의 주문 감사합니다.");
    			break;
    		} else {

    		}
            
		}
    	
    	scanner.close();
        
    }
}
