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
import static labs.pm.data.Rating.*;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.util.Objects;
import java.time.LocalDate;
import java.io.Serializable;
/**
*
* @author HJVH
* @version 1.0
* @since 2021-08-26
*/
public abstract class Product implements Rateable<Product>, Serializable{
	/**
	* A constant that defines a {@link java.math.BigDecimal BigDecimal} value
	* of the discount rate
	* <br>
	* discount rate is 10%
	*/
	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	private Rating rating;
	
	/*
	Product(){
		this(0,"No Name",BigDecimal.ZERO);
	}
	*/
	
	Product(int id,String name,BigDecimal price){
		this(id,name,price,NOT_RATED);
	}
	
	Product(int id,String name,BigDecimal price,Rating rating){
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public BigDecimal getPrice(){
		return this.price;
	}
	
	/**
	* Calculates discounts based on a product price and
	* {@link DISCOUNT_RATE discount rate}
	* 
	* public BigDecimal setScale​(int newScale, RoundingMode roundingMode)
	* newScale => amounts of decimals digits
	* @return a {@link java.math.BigDecimal BigDecimal} value of the discount
	*/
	public BigDecimal getDiscount(){
		return price.multiply(DISCOUNT_RATE).setScale(2,HALF_UP);
	}
	@Override
	public Rating getRating(){
		return this.rating;
	}
	
	/**
	* Get the value of bestBefore
	* @return the value of bestBefore
	*/
	public LocalDate getBestBefore(){
		return LocalDate.now();
	}
	
	@Override
	public String toString(){
	return id+", "+name+", "+price+", "+getDiscount()+", "+rating.getStars()+", "+getBestBefore();
	}
	
	/*
		equals() and hashCode() must be overridden to provide custom mechanism for
		comparing Product objects. Overriding equals() we are just interested to get
		the same instance type but no the same reference.
	*/
	
	@Override
	public int hashCode(){
		int hash = 5;
		hash = 23*hash+this.id;
		return hash;
	}
	@Override
	public boolean equals(Object obj){
		if(this == obj){return true;}
		//if(obj != null && getClass() == obj.getClass()){
		if(obj instanceof Product){
			final Product other = (Product) obj;
			return this.id == other.id /*&& Objects.equals(this.name,other.name)*/;
		}
		return false;
	}
	
}