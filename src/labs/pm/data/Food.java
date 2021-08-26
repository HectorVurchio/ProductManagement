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
import java.time.LocalDate;
import java.math.BigDecimal;

public class Food extends Product{
	private LocalDate bestBefore;
	
	Food(int id,String name,BigDecimal price,Rating rating,LocalDate bestBefore){
		super(id,name,price,rating);
		this.bestBefore = bestBefore;
	}
	/**
	* Get the value of bestBefore
	* @return the value of bestBefore
	*/
	public LocalDate getBestBefore(){
		return this.bestBefore;
	}
	/**
	* apply 10% discount if the product bestBefore date is today
	*/
	@Override 
	public BigDecimal getDiscount(){
		return (bestBefore.equals(LocalDate.now())) ? super.getDiscount() : BigDecimal.ZERO;
	}
	@Override
	public String toString(){
		return super.toString()+", "+bestBefore;
	} 
	/**
	* Implementation of the abstract method in the parent class
	*/
	@Override
	public Product applyRating(Rating newRating){
		return new Food(getId(),getName(),getPrice(),newRating,bestBefore);
	}
}