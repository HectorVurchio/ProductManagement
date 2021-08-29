/**
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the license, or 
* (at your option) later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARANTY, witout even the implied waranty at
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. see the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/
package labs.pm.app;
import labs.pm.data.Product;
import labs.pm.data.Food;
import labs.pm.data.Drink;
import labs.pm.data.Rating;
import labs.pm.data.ProductManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Comparator;
import java.util.function.Predicate;

/**
* @author HJVH
* @version 1.0
* @since 2021-08-26
*/
public class Shop{
	/**
	* @param args the command line arguments
	*/
	public static void main(String[] args){
		ProductManager pm = new ProductManager(Locale.UK);
		//pm.createProduct(101,"Tea",BigDecimal.valueOf(1.99),Rating.NOT_RATED);
		pm.printProductReport(101);
		pm.printProductReport(103);
		
		pm.createProduct(164,"Kombucha",BigDecimal.valueOf(1.99),Rating.NOT_RATED);
		pm.reviewProduct(164,Rating.TWO_STAR,"Looks like tea but it is!");
		pm.reviewProduct(164,Rating.FOUR_STAR,"Fine tea");
		pm.reviewProduct(164,Rating.FOUR_STAR,"This is not tea");
		pm.reviewProduct(164,Rating.FIVE_STAR,"Perfect!");
		pm.printProductReport(164);
			
		pm.printProducts(p -> p.getPrice().floatValue() < 2,
							(p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
							
		pm.getDiscounts().forEach((rating,discount) -> System.out.println(rating + "\t"+ discount));
	}
}

/*
javac -d compiled src/labs/pm/data/*.java src/labs/pm/app/Shop.java


*/