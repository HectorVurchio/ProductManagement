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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

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
		ProductManager pm = ProductManager.getInstance();
		AtomicInteger clientCount = new AtomicInteger(0);
		Callable<String> client = ()->{
			String clientId = "Client "+clientCount.incrementAndGet();
			String threadName = Thread.currentThread().getName();
			String languageTag = productManager
								.getSupportedLocales()
								.stream()
								.skip(ThreadLocalRandom.current().nextInt(5))
								.findFirst().get();
			StringBuilder log = new StringBuilder();
			log.append(clientId+threadName+"\n-\tstart of log\t-\n");
			log.append(pm.getDiscounts(languageTag)
							.entrySet()
							.stream()
							.map(entry -> entry.getKey()+"\t"+entry.getValue())
							.collect(Collectors.joining("\n")));
			log.append("\n\tend of log\t-\n");
			return log.toString();
		};
	}
}

/*
javac -d compiled src/labs/pm/data/*.java src/labs/pm/app/Shop.java


*/