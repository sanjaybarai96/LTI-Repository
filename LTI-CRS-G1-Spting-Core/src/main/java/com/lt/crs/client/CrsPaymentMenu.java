package com.lt.crs.client;

import com.crs.lt.beans.User;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Menu;
import com.crs.lt.util.Utils;

/**
 * @author user215
 * This is the payment menu
 *
 */
public class CrsPaymentMenu {
	private PaymentService paymentService = new PaymentService();
	private BillingService billingService = new BillingService();

	public void createMenu(User user)
	{   
		boolean isExit = false;
		while(!isExit) {
			if(paymentService.checkPayment(user.getUserId())==null) {		
				double totalBill = billingService.generateBill(user.getUserId());

				System.out.println("Your total bill is \u20B9 "+totalBill);
				if(totalBill>0) {
					Utils.printStatement("Select Payment Mode");
					Utils.printStatement(String.format(Menu.PaymentMenu,Menu.BackButton));
					InputConstants.optionNumber=InputConstants.sc.nextInt();	

					switch (InputConstants.optionNumber)
					{
					case 1:
						paymentService.paymentOption(user.getUserId(),totalBill);
						break;
					case 2:
						//Cash
						break;
					case 3:
						// Cheque
						break;
					case 4:
						//Scolarship
						break;
					case 5:
						//Scolarship
						break;
					case 6:
						isExit = true;
						break;

					default:
						break;
					}
				}else {
					System.out.println("Please add the course.");
					isExit = true;
				}
			}else {
				System.out.println("You have already paid.");
				isExit = true;
			}
		}
	}
}

