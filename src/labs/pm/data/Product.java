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
import static java.math.RoundingMode.HALF_UP;
/**
*
* @author HJVH
* @version 1.0
* @since 2021-08-26
*/
public class Product{
	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public BigDecimal getPrice(){
		return this.price;
	}
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	//public BigDecimal setScale​(int newScale, RoundingMode roundingMode)
	//newScale => amounts of decimals digits
	public BigDecimal.getDiscount(){
		return price.multiply(DISCOUNT_RATE).setScale(2,HALF_UP);
	}
}