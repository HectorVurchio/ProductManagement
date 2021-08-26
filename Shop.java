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
import java.math.BigDecimal;
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
		Product p1 = new Product();
		p1.setId(101);
		p1.setName("Tea");
		p1.setPrice(BigDecimal.valueOf(1.99));
		System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getPrice());
	}
}