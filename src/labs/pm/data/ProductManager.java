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

package labs.pm.data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.text.MessageFormat;

/**
*
* @author HJVH
* @version 1.0
* @since 2021-08-26
*/
public class ProductManager{
	private Locale locale;
	private ResourceBundle resources;
	private DateTimeFormatter dateFormat;
	private NumberFormat moneyFormat;

	private Map<Product,List<Review>> products = new HashMap<>();
	public ProductManager(Locale locale){
		this.locale = locale;
		resources = ResourceBundle.getBundle("labs.pm.data.resources",locale);
		dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
		moneyFormat = NumberFormat.getCurrencyInstance(locale);
	}
	public Product createProduct(int id,String name,BigDecimal price,Rating rating,LocalDate bestBefore){
		Product product = new Food(id,name,price,rating,bestBefore);
		products.putIfAbsent(product,new ArrayList<>());
		return product;
	}
	
	public Product createProduct(int id,String name,BigDecimal price,Rating rating){
		Product product = new Drink(id,name,price,rating);
		products.putIfAbsent(product,new ArrayList<>());
		return product;
	}
	
	public Product reviewProduct(int id,Rating rating,String comments){
		return reviewProduct(findProduct(id),rating,comments);
	}
	
	public Product reviewProduct(Product product,Rating rating,String comments){
		List<Review> reviews = products.get(product);
		products.remove(product,reviews);
		reviews.add(new Review(rating,comments));
		int sum = 0;
		for(Review review : reviews){
			sum += review.getRating().ordinal();
		}
		product = product.applyRating(Rateable.convert(Math.round((float)sum/reviews.size())));
		products.put(product,reviews);
		return product;
	}
	
	public Product findProduct(int id){
		Product result = null;
		for(Product product : products.keySet()){
			if(product.getId() == id){
				result = product;
				break;
			}
		}
		return result;
	}
	
	public void printProductReport(int id){
		printProductReport(findProduct(id));
	}
	
	public void printProductReport(Product product){
		List<Review> reviews = products.get(product);
		StringBuilder txt = new StringBuilder();
		txt.append(MessageFormat.format(resources.getString("product"),
										product.getName(),
										moneyFormat.format(product.getPrice()),
										product.getRating().getStars(),
										dateFormat.format(product.getBestBefore())));
		txt.append("\n");
		//get reviews sorted by stars
		Collections.sort(reviews);
		for(Review review : reviews){
			txt.append(MessageFormat.format(resources.getString("review"),
												review.getRating().getStars(),
												review.getComments()));
			txt.append("\n");
		}
		if(reviews.isEmpty()){
			txt.append(resources.getString("no.reviews"));
			txt.append("\n");
		}
		System.out.println(txt);
	}
}



