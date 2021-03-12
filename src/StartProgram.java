import java.util.List;
import java.util.Scanner;

import controller.ListHelper;
import model.ClothesWholesaleRugji;
/**
 * Arda Rugji arugji
 * CIS171 
 */
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static ListHelper lh = new ListHelper();

	private static void addCloth() {
		// TODO Auto-generated methodtub
		System.out.print("Enter the brand: ");
		String info1 = in.nextLine();
		System.out.print("Enter the item name : ");
		String info2 = in.nextLine();
		
		 ClothesWholesaleRugji toAdd = new ClothesWholesaleRugji(info1,info2);
		lh.insertCloth(toAdd);

	}

	private static void deleteCloth() {
		// TODO Auto-generated method stub
		System.out.print("Enter the brand to delete: ");
		String info1 = in.nextLine();
		System.out.print("Enter the item name to delete: ");
		String info2 = in.nextLine();

	
		ClothesWholesaleRugji toDelete = new ClothesWholesaleRugji(info1,info2);
		lh.deleteCloth(toDelete);
	}

	private static void editCloth() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Brand");
		System.out.println("2 : Search by Item name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ClothesWholesaleRugji> founds;
		if (searchBy == 1) {
			System.out.print("Enter the brand: ");
			String manuName = in.nextLine();
			founds = lh.searchForClothByBrand(manuName);
			
		} else {
			System.out.print("Enter the item name: ");
			String itemName = in.nextLine();
			founds = lh.searchForItemByClothModel(itemName);

		}

		if (!founds.isEmpty()) {
			System.out.println("Found Results.");
			for (ClothesWholesaleRugji c : founds) {
				System.out.println(c.getId() + " : " + c.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ClothesWholesaleRugji toEdit = lh.searchForClothById(idToEdit);
			System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getBrand());
			System.out.println("1 : Update Brand");
			System.out.println("2 : Update Item Name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Brand: ");
				String newBr = in.nextLine();
				toEdit.setBrand(newBr);
			} else if (update == 2) {
				System.out.print("New Item: ");
				String newItem = in.nextLine();
				toEdit.setItem(newItem);
			}

			lh.updateCloth(toEdit);

		} else {
			System.out.println("---- No results found");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a cloth");
			System.out.println("*  2 -- Edit a cloth");
			System.out.println("*  3 -- Delete a cloth");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addCloth();
			} else if (selection == 2) {
				editCloth();
			} else if (selection == 3) {
				deleteCloth();
			} else if (selection == 4) {
				viewTheList();
			} else {
				//lh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
					List<ClothesWholesaleRugji> allClothes = lh.showAllClothes();
					for(ClothesWholesaleRugji singleCloth : allClothes){
					System.out.println(singleCloth.returnClothesInfo());
		

	}

	}

}
